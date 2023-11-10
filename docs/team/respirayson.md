---
layout: default.md
title: "Rayson Yeap's Project Portfolio Page"
---
### Project: F.A.K.E.J.A.R.V.I.S.

F.A.K.E.J.A.R.V.I.S. is a desktop application to help CS1101S Avengers manage their time and job more effectively by creating a one-stop platform that aggregates information from multiple sources. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 27 kLoC.

Given below are my contributions to the project.


* **New Feature**: Added the ability to add new tasks.
  * What it does: enables users to create and input new tasks into the platform, allowing for easy tracking and organisation of the Avenger's to-do lists.
  * Justification: This feature improves the product significantly because it provides Avengers a centralised task management system, eliminating the need to switch between multiple task management tools. This helps to streamline workflows and save time. Additionally, this reinforces the platform's vision to be a comprehensive, all in one solution for Avengers and their responsibilities. 
  * Highlights: This enhancement was designed to accommodate future implementations of new fields. Thorough analysis was done to ensure its versatility. There was also some design thought given to how we were going to store the model. The model was chosen to be stored separately so that corruption of the data in the address book would not affect the data in th task list.
  * Credits: No reuse of code or third-party libraries.
  

* **New Feature**: Added the ability to delete existing tasks.
  * What it does: enables users to remove unwanted or completed tasks from their task list.
  * Justification: This feature improves the product significantly because it provides Avengers a way to maintain their task list. Otherwise, the list would just get longer and longer. Avengers might need to remove tasks that are no longer relevant or have been completed already. This maintains the organised and efficient task management process.
  * Credits: No reuse of code or third-party libraries.


* **New Feature**: Added the ability to view tasks.
  * What it does: enables users to access and filter their existing tasks within the application, providing a comprehensive overview of their to-do list.
  * Justification: This feature is a significant enhancement to the product, as it addresses a fundamental user need – the ability to effortlessly access and assess their tasks within the platform. Users need a convenient way to see their tasks and their details, enabling them to stay organized and make informed decisions about task prioritization and completion.
  * Highlights: This enhancement needs to be able to filter the tasks based on every single field. This implementation was challenging as it required coming up with a way to make one command general enough to use any predicate. This is where Java generics came in handy, namely the Predicate<Task>. By accepting a generic predicate, we can use multiple different predicates that apply on different fields of the tasks. And all this can be done in one command. 
  * Credits: No reuse of code or third-party libraries.


* **Code contributed**: [RepoSense](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=respirayson&breakdown=true)


* **Project management**: 
  * Managed release `v1.2`
  * Helped to set up the organisation and repository
  * Reviewed and approved pull requests
  * Set up the GitHub issues and different types


* **Enhancements to existing features**:


* **Documentation**:
    * User Guide:
      * Added documentation for the Task Management Section
      * Did up the Command Format section, how to use the user guide and the errors table
      * Expanded on the command summary with some examples
      * Formatted the features of the user guide section with the command parameters table and the examples block
  
    * Developer Guide:
      * Added implementation details of the `addtask`, `deletetask`, `viewtasks` and `updatetaskprogress` feature.
      * Designed the class diagram for `Task`.
      * Designed the sequence diagram for `CommandParser` and the reference frames for some of the `XYZCommandParser` features.


* **Review/mentoring contributions**:
  * Contributed to forum discussions which helped to solve some of their issues (examples: [1](https://github.com/nus-cs2103-AY2324S1/forum/issues/50#issuecomment-1697613064), [2](https://github.com/nus-cs2103-AY2324S1/forum/issues/68#issuecomment-1702871519), [3](https://github.com/nus-cs2103-AY2324S1/forum/issues/146#issuecomment-1720759103), [4](https://github.com/nus-cs2103-AY2324S1/forum/issues/285#issuecomment-1774793066))


* **Tools**: To be added

* **Contributions beyond the project team**: To be added

