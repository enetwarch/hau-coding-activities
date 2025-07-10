# Subjects

```bash
hau-coding-activities/ # repository
|--subjects/ # this directory
|  |--6dsal/...
|  |--6logprog/...
|  |--6oop/ # subject directory
|  |  |--2025-06-16-1/ # activity year-month-date-number directory
|  |  |  |--directory/... # additional subdirectories
|  |  |  |--Main.java # source code file
|  |  |  |--Utils.java # more source code files
|  |  |--2025-06-30-1/... # first activity for 2025-06-30
|  |  |--2025-06-30-2/... # second activity
|  |  |--2025-06-30-3/... # third activity
|  |  |--README.md # subject course details
|  |--6progsdats/...
|  |--6webcs/...
```

This is the general structure of the [`subjects/`](./) directory. Subject folders will pertain to the subject abbreviation with [`6oop/`](./6oop/) as an example. The `year-month-date-number` directory consists of numerical values which should end up like [`2025-06-16-1/`](./6oop/2025-06-16/), meaning it is an activity that happened on **June 16, 2025**. The last number in the `year-month-date-number` directory indicates the activity number, which in most cases will be **1** because most days will only have one activity.

## File Naming

Files will have semantic naming if the activity just consists of one file like `calculator.py`. If the activity requires multiple files working together, the file that contains the main method or entry point will be named `main.*` with `*` referring to any extension. As much as possible, all classes and functions will live in one file for easy compilation, unless the instructions explicitly mention that they have to be separate. Capitalization and naming for each file will ultimately depend on that language's naming convention and practices. Sensitive activity files and some quizzes will not be included in this repository.

## Code Comments

Comments will be abundant in this codebase as it is a school activity repository. Most of these comments will explain the obvious and are often unnecessary but it is a requirement to avoid potential deductions due to lack of documentation. To make these comments less intrusive, they will be written on top of the class or function header. Inlining comments should be an absolute last resort as adding a few, let alone too many, will plague the codebase. With all of that in mind however, some activites do not have comments at all as the instructions did not require it or it is done in [CodeChum](https://codechum.com/) or other coding platforms.
