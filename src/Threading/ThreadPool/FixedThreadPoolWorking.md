# Internal Working of newFixedThreadPool In Java

## 1. What Is newFixedThreadPool?
- Creates a fixed number of core threads.
- Core threads never terminate unless shutdown() is called.
- Excess tasks are added to BlockingQueue.

---

##  2. Task Submission Flow
- Task submitted → Core thread picks it.
- If all threads busy → Task goes to BlockingQueue.
- If queue full → Task is rejected.

---

## 3. Core Thread Creation
- First task → Creates a core thread.
- Keeps creating threads until corePoolSize is reached.
- Core threads stay alive until shutdown().

---

## 4. BlockingQueue Behavior
- Holds tasks when all threads are busy.
- Task waits in the queue until a thread is free.
- If the queue is full → Task rejected.

---

## 5. Task Rejection
- When:
    - All threads are busy.
    - Queue is full.
- Throws:
```plaintext
RejectedExecutionException
