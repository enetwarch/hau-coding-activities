# Holy Angel University Coding Activities

This repository is a collection of all the coding activities we have done in [**Holy Angel University**](https://www.hau.edu.ph/). These activities were designed to help us strengthen our foundation and understanding of programming concepts through the use of practical hands-on tasks. All of the files here are **personal solutions** to the given problems from [**HAU Canvas**](https://hau.instructure.com/). Instructions are copy pasted or manually written in the [README.md](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax) file of the activity directory.

## Folder Structure

```yaml
/hau-coding-activities # repository
|--/2062-6OOP # subject
|  |--/2025-06-16 # activity year-month-date
|  |  |--/docs # documentation files
|  |  |  |--image.png
|  |  |  |--document.pdf
|  |  |--/src # source code
|  |  |  |--Main.java
|  |  |--README.md # activity instructions
|  |--README.md # course details
```

This is the rough folder structure of the repository. The naming convention for each directory should be in [`kebab-case`](https://developer.mozilla.org/en-US/docs/Glossary/Kebab_case). Folders like `subject` will pertain to the class code and subject abbreviation with [`/2062-6OOp`](./2062-6OOP/) as an example. The `year-month-date` directory consists of numerical values which should end up like [`/2025-06-16`](./2062-6OOP/2025-06-16/), meaning it is an activity that happened on **June 16, 2025**. 

### Edge Case

```yaml
/hau-coding-activities #repository
|--/6PROGSDATS # subject
|  |--/2024-12-16-1 # first activity 
|  |  |--/...
|  |--/2024-12-16-2 # second activity
|  |  |--/...
|  |--/2024-12-16-3 # third activity
|  |  |--/...
```

In a situation where multiple activities occur on a single date, it will have another number at the end indicating the activity number. Instead of `2024-12-16`, The directory name will be `2024-12-16-1` for the first activity, `2024-12-16-2` for the second, and so on.

## License

This project is licensed under the [MIT license](./LICENSE).
