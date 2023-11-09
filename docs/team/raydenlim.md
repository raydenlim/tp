---
layout: default.md
title: "Jian Song (rayden)'s Project Portfolio Page"
---

### Name: Rayden
**Bio:** <br>
* I am interested in cybersecurity
* I believe that laughter is the best medicine

### **Joke of the day**<br>
**QNS :** Why did the programmer constantly run into bugs? <br>
**ANS :** Because he used light mode, and bugs are attracted to the light.

### Project: F.A.K.E.J.A.R.V.I.S.
![Logo](images/fakejarvis.png)

F.A.K.E.J.A.R.V.I.S. is a brownfield project built on Address Book 3 (AB3), with the intention to help CS1101S Avengers manage their Teaching Assistant (TA) duties.

Given below are my contributions to the project.

* **New Feature 1**: Added the Graded Test component
  * **What it does**: Enables users to view the graded tests of their students at a glance.
  * **Justification**: Currently in CS1101S, the Avengers would have to navigate through the many folders in Canvas to access their student's results 1 by 1. This process is time-consuming as the grades are not consolidated in one single platform.
  * **Highlights**: The graded tests are displayed within the Student's card, enabling the Avengers to retrieve their student's grades at a glance. This provides a super convenient way for Avengers to better track their student's performance.
  * **Credits**: No reuse of code or third-party libraries used.

<br>

* **New Feature 2**: Added the ability to edit graded tests.
  * **What it does**: Enables users to dynamically edit their student's graded test scores.
  * **Justification**: The ability to edit graded test scores is essential to accommodate situations where grades may need to be adjusted, updated, or corrected.
  * **Highlights**: As the fields are optional, users can easily modify the scores for individual components of a student's graded test, without having to key in the scores for the unconcerned fields. Moreover, graded test scores can be edited  via the `edit` and `editgradedtest` command.
    * `edit INDEX gt/ RA1:0 | RA2:0 | MidTerms:0 | Finals:0 | PE:0`
      * Readability: The command is more descriptive, making it clear that it is editing a person's graded test.
      * Flexibility: Users can potentially edit other person-related attributes if needed in the future by
        extending the command.
    * `editgradedtest ra1/0 ra2/0 mt/0 f/0 pe/0`
      * Conciseness: It's shorter and easier to type, which can be beneficial if users need to edit graded test scores frequently.
      * Consistency: If the primary use case for this command is editing graded test scores, it might provide a more streamlined experience.
  * **Credits**: No reuse of code or third-party libraries used.
    <br>

* **Code contributed**: [raydenlim's RepoSense](https://tinyurl.com/CS2103T15raydenlim)
  <br>

* **Enhancements implemented**:

<br>

* **Documentation**:
  * **Contributions to User Guide**:
    * Added documentation for Graded Test Management Section.
    * Organised the format of the User Guide.
    * Expanded on the command summary with examples.
    * Updated the Tables of Content.

    <br>
  * **Contributions Developer Guide**:
    * Designed the class diagram for `GradedTest`

<br>

* **Community**:
  * **Contributions to team-based tasks**:
    * Updated User Guide and Error Messages to be more lucid.
    * Set up an Excel Sheet for PE-D bugs for enhanced clarity.
    * Made the logo for F.A.K.E.J.A.R.V.I.S.
    * Update the logo of the UI.
    * Bug Hunting.

    <br>

  * **Review/mentoring contributions**:
    * [raydenlim's tp comments](https://nus-cs2103-ay2324s1.github.io/dashboards/contents/tp-comments.html#9-lim-song-raydenlim-73-comments)

  <br>

  * **Contributions beyond the project team**:
    * [raydenlim's forum post](https://nus-cs2103-ay2324s1.github.io/dashboards/contents/forum-activities.html#60-lim-song-raydenlim-6-posts)
    * Contributed to forum discussions, and shared some unusual bugs and how to resolve them. (examples: [Assisting](https://github.com/nus-cs2103-AY2324S1/forum/issues/122#issuecomment-1711100005),
      [Unusual Bugs](https://github.com/nus-cs2103-AY2324S1/forum/issues/274#issuecomment-1770647394))

<br>

* **Tools**:
  * Java
  * IntelliJ
  * FXML
  * PlantUML
  * GitHub
  * CATcher Smoke Test
