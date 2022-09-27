package linkedIn.design.blockingqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*Start with single-put/get implementation. Check for thread-safety and
correctness initially. if satisfied, ask the interviewee to implement multi-put.
Follow-up question is to get the candidate talk about different locking strategies
and how to improve concurrency

A great candidate :
Will understand the writers (in the presence of multi-put) need to be synchronized in
addition to global locking.
 */

public class BlockingBoundedQueue implements MultiPutBlockingBoundedQueue {

    private boolean _isInitDone;
    private int _capacity;
    private LinkedList _buffer;
    private int _currSize;
    private ReentrantLock _writerLock;
    private ReentrantLock _lock;
    private Condition _notEmpty;
    private Condition _notFull;

    @Override
    public void init(int capacity) throws Exception {
        if (_isInitDone)
            throw new Exception("Already inited !!");
        if (capacity <= 0)
            throw new Exception("Capacity <= 0 ");
        _capacity = capacity;
        _buffer = new LinkedList();
        _currSize = 0;
        _writerLock = new ReentrantLock();
        _lock = new ReentrantLock();
        _notEmpty = _lock.newCondition();
        _notFull = _lock.newCondition();
        _isInitDone = true;
    }

    private void assertInited() throws Exception {
        if (!_isInitDone)
            throw new Exception("Init not done !!");
    }

    @Override
    public Object get() throws Exception {
        assertInited();
        try {
            _lock.lock();
            while (_currSize <= 0) {
                try {
                    _notEmpty.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            _currSize--;
            _notFull.signal();
            return _buffer.remove(0);
        } catch (Exception ex) {
            throw ex;
        } finally {
            _lock.unlock();
        }
    }

    @Override
    public void put(Object obj) throws Exception {
        assertInited();
        try {
            _writerLock.lock();
            _lock.lock();
            {
                while (_currSize >= _capacity) {
                    try {
                        _notFull.await();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            _currSize++;
            _buffer.add(obj);
            _notEmpty.signal();
        } catch (Exception ex) {
            throw ex;
        } finally {
            _lock.unlock();
            _writerLock.unlock();
        }
    }

    @Override
    public void multiput(List objs) throws Exception {
        assertInited();
        try {
            _writerLock.lock();
            _lock.lock();
            for (Object obj : objs) {
                while (_currSize >= _capacity) {
                    try {
                        _notFull.await();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                _buffer.add(obj);
                _currSize++;
                _notEmpty.signal();
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _lock.unlock();
            _writerLock.unlock();
        }
    }
}
