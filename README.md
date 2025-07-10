# Holy Angel University Coding Activities

This repository is a collection of all the coding activities we have done in [**Holy Angel University**](https://www.hau.edu.ph/). These activities were designed to help us strengthen our foundation and understanding of programming concepts through the use of practical hands-on tasks. All of the files here are **my personal solutions** to the given problems from [**HAU Canvas**](https://hau.instructure.com/).

## Repository Structure

```bash
hau-coding-activities/ # repository
|--.github/ # ci/cd pipelines and github specific files
|--subjects/ # main directory
|--.gitignore # ignores certain file names when doing git add .
|--LICENSE # mit license
|--README.md # this documentation file
|--... # other root directory files
```

This is the rough repository structure of this repository. The naming convention for each directory should be in [`kebab-case`](https://developer.mozilla.org/en-US/docs/Glossary/Kebab_case). Each major directory will have a `README.md` file of their own that documents their own internals. The root directory of the repository contains standard GitHub files, including the [`.gitignore`](https://git-scm.com/docs/gitignore), `LICENSE`, package managers, config files, and this `README.md` file.

### Package Managers and Config Files

```bash
hau-coding-activities/ # repository
|--package.json # node package manager config file for web dev
|--pnpm-lock.yaml # pnpm lock file for package.json
|--eslint.config.mjs # web dev linter config file
|--prettier.config.mjs # web dev formatter config file
|--... # stacks from other ecosystems
```

These files live in the root directory, making it look bigger than it really is. Most of these package manager and config files are just here for the developer experience (DX). Package managers like [pnpm](https://pnpm.io/), formatters like [Prettier](https://prettier.io/) and linters like [ESLint](https://eslint.org/) have their own config files, somewhat contributing to the scale of the repository. The aforementioned stack of files are all for web dev specifically (HTML, CSS, JavaScript, etc.) which means there will be more stacks for other ecosystems such as Java, Python, and many others.

## License

This project is licensed under the [MIT license](./LICENSE).
