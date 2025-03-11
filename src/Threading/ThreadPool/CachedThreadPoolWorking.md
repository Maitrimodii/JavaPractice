# CachedThreadPool in Java

## Overview
- `Executors.newCachedThreadPool()` creates a thread pool that **dynamically creates threads** as needed.
- If threads are **idle for 60 seconds**, they are terminated.
- No upper limit on thread creation, may lead to **OutOfMemoryError**.

## How It Works
1. Task is submitted using `execute()` method.
2. **If an idle thread** exists, it picks up the task.
3. **If no idle thread**, a **new thread** is created.
4. After **60 seconds of no work**, the thread is terminated.

## Key Features
| Feature            | CachedThreadPool                                    |
|--------------------|----------------------------------------------------|
| Thread Creation     | Unlimited, based on task arrival.                 |
| Thread Termination | Terminates if idle for **60 seconds**.             |
| Task Handling      | Directly handed over to available thread.          |
| Risk               | Can cause **OutOfMemoryError** if too many tasks. |

## When to Use
- Short-lived tasks like **API requests, email sending, logging**.
- High-throughput tasks with **fast completion time**.

## When to Avoid
- **Long-running tasks**, as threads may pile up.
- CPU-intensive tasks which need controlled thread creation.

## Comparison: CachedThreadPool vs FixedThreadPool
| Feature              | CachedThreadPool                        | FixedThreadPool                      |
|----------------------|---------------------------------------|-------------------------------------|
| Thread Creation     | Unlimited                              | Fixed number of threads            |
| Task Handling      | Directly assigned                      | Queued if threads are busy        |
| Best For           | **Short-lived tasks**                   | **Constant number of tasks**       |
| Risk               | **OutOfMemoryError**                    | Predictable resource usage        |

