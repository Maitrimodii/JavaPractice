# WorkStealingPool in Java

## Overview
- `Executors.newWorkStealingPool()` creates a **ForkJoinPool-based** thread pool.
- Uses **work-stealing** where idle threads steal tasks from busy threads.
- Default thread count is `Runtime.getRuntime().availableProcessors()`.

## How It Works
1. Tasks are **distributed** among worker threads.
2. Each thread has a **local queue** for tasks.
3. If a thread's queue is **empty**, it **steals** work from another thread.
4. Ensures **better CPU utilization** and **load balancing**.

## Key Features
| Feature            | WorkStealingPool                                    |
|--------------------|----------------------------------------------------|
| Thread Allocation  | Creates threads equal to available CPU cores.     |
| Task Distribution | Tasks are dynamically **stolen** when needed.     |
| Ideal Use Case    | **Parallel processing**, CPU-bound tasks.         |
| Blocking Tasks    | Not recommended, may lead to thread starvation.   |

## When to Use
- CPU-intensive tasks (e.g., **parallel computations**).
- Recursive workloads (**Fork/Join-like tasks**).
- Large data processing where tasks are **not dependent** on each other.

## When to Avoid
- **IO-bound tasks** (threads may remain idle).
- **Blocking operations** (e.g., waiting on database, network calls).

## Comparison: WorkStealingPool vs CachedThreadPool
| Feature              | WorkStealingPool                        | CachedThreadPool                      |
|----------------------|---------------------------------------|--------------------------------------|
| Thread Count        | Fixed to CPU cores                    | Grows dynamically                    |
| Task Handling      | Uses **work stealing**                | Assigns tasks randomly               |
| Best For          | **Parallel tasks**                     | **Short-lived tasks**                |

