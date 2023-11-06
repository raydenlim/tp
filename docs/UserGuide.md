---
layout: default.md
title: "User Guide"
pageNav: 3
---

# F.A.K.E.J.A.R.V.I.S. User Guide

## Introduction
_Say goodbye to chaos and hello to an organized and efficient classroom experience._


<p align="center">
  <img src="images/fakejarvis.png" width="200px">
</p>


F.A.K.E.J.A.R.V.I.S. is your **friendly companion for efficient task and administrative management**, allowing you to excel as a CS1101S Avenger. With this tool, you can effortlessly track assignment gradings, monitor student participation, and seamlessly plan tutorials, consultations, and mastery checks. 

As Avengers ourselves, we understand the importance of managing both our time and our students effectively. F.A.K.E.J.A.R.V.I.S. is the one-stop solution to streamlining your workload, making your life easier. It is designed to empower you with the benefits of a Command-Line Interface(CLI), all while preserving the advantages of having a Graphical User Interface(GUI).

If you are new to CLI, or unfamiliar with the commands F.A.K.E.J.A.R.V.I.S. offers and need assistance, don't worry! This UserGuide is your trusted assistant, and will guide you through every step and ensure that you can unlock the full potential of F.A.K.E.J.A.R.V.I.S. Let's get started!

<!-- * Table of Contents -->
<page-nav-print />

<br>

### Table of Contents

* [Introduction](#introduction)
    * [Table of Contents](#table-of-contents)
    * [How to use the User Guide](#how-to-use-the-user-guide)
* [Graphical User Interface](#graphical-user-interface)
    * [Task Card](#task-card)
    * [Consultation Card](#consultation-card)
    * [Session Card](#session-card)
* [Quick Start](#quick-start)
* [Command Format](#command-format)
    * [Command Parameters](#command-parameters)
* [Features](#features)
    * [General Commands](#general-commands)
        * [Viewing help : `help`](#viewing-help-help)
        * [Exiting F.A.K.E.J.A.R.V.I.S. : `exit`](#exiting-fakejarvis-exit)
        * [Saving the Data](#saving-the-data)
        * [Editing the Data File](#editing-the-data-file)
        * [Archiving Data Files `[coming in v2.0]`](#archiving-data-files-coming-in-v20)
    * [Student Management](#student-management)
        * [Adding a Student: `add`](#adding-a-student-add)
        * [Listing All Students : `list`](#listing-all-students-list)
        * [Editing a Student Field : `edit`](#editing-a-student-field-edit)
        * [Locating Student by Name: `find`](#locating-student-by-name-find)
        * [Deleting a Student : `delete`](#deleting-a-student-delete)
        * [Clearing all Entries : `clear`](#clearing-all-entries-clear)
    * [Task Management](#task-management)
        * [Adding a Task: `addtask`](#adding-a-task-addtask)
        * [Viewing Tasks: `viewtasks`](#viewing-tasks-viewtasks)
        * [Updating a Task's Progress: `updateprogress`](#updating-a-tasks-progress-updateprogress)
        * [Deleting a Task: `deletetask`](#deleting-a-task-deletetask)
    * [Attendance Management](#attendance-management)
        * [Taking Attendance: `takeattendance`](#taking-attendance-takeattendance)
        * [Viewing Attendance: `viewattendance`](#viewing-attendance-viewattendance)
    * [Assignment Management](#assignment-management)
        * [Viewing a list of Assignments: `viewassignments`](#viewing-a-list-of-assignments-viewassignments)
        * [Editing an Assignment Grade: `editgrade`](#editing-an-assignment-grade-editgrade)
        * [Deleting an Assignment Grade: `deletegrade`](#deleting-an-assignment-grade-deletegrade)
        * [Editing an Assignment Comment: `editcomment`](#editing-an-assignment-comment-editcomment)
        * [Deleting an Assignment Comment: `deletecomment`](#deleting-an-assignment-comment-deletecomment)
    * [Graded Test Management](#graded-test-management)
        * [Editing a Graded Test Score: `editgradedtest`](#editing-a-graded-test-score-editgradedtest)
    * [Session Management](#session-management)
        * [Creating a Session: `createsession`](#creating-a-session-createsession)
        * [Updating a Session's Remark: `updatesessionremark`](#updating-a-sessions-remark-updatesessionremark)
        * [Deleting a Session: `deletesession`](#deleting-a-session-deletesession)
    * [Consultation Management](#consultation-management)
        * [Creating a Consultation: `createconsult`](#creating-a-consultation-createconsult)
        * [Adding students to a consultation: `addtoconsult`](#adding-students-to-a-consultation-addtoconsult)
        * [Removing Students from a Consultation: `removefromconsult`](#removing-students-from-a-consultation-removefromconsult)
        * [Deleting a Consultation: `deleteconsult`](#deleting-a-consultation-deleteconsult)
* [FAQ](#faq)
* [Known Issues](#known-issues)
* [Command Summary](#command-summary)
* [Encountering Errors](#encountering-errors)


<br>


### How to use the User Guide
You may refer to the **Table of Contents** on the right for easy navigation of the User Guide.

The F.A.K.E.J.A.R.V.I.S. User Guide employs a variety of visual cues to enhance the information it presents. The table below offers an overview of the typographical conventions used.

| Convention     | Description                                                    |
|----------------|----------------------------------------------------------------|
| `Monospace`    | Used for command inputs, syntax, and file paths.               |
| **Bold text**  | Highlights important keywords.                                 |
| [Hyperlink](#) | Indicates hyperlinks to external websites or within the guide. |

<br>

| Convention                                                                          | Description                                                     |
|-------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| **<div markdown="span" class="alert alert-info"> :information_source: Note </div>** | Provides information of special interest or importance.         |
| **<div markdown="span" class="alert alert-warning"> :bangbang: Warning </div>**     | Alerts to potentially irreversible actions with data loss risk. |

<br>

| Convention | Description                    |
|------------|--------------------------------|
| 📝         | Add <br/> Create               |
| ❌          | Delete <br/> Remove            |
| 🛠️        | Edit <br/> Modify <br/> Update |
| 🔎         | Find                           |
| 📆         | Take Attendance                |
| 👀         | View <br/> Display </br> List  |





[Back to Table of Contents](#table-of-contents)


--------------------------------------------------------------------------------------------------------------------


## Graphical User Interface

![UI with Annotations](images/newUiWithAnnotations.png)

F.A.K.E.J.A.R.V.I.S.'s graphical user interface consists of 4 main components:
* Command Box
* Command Result Display
* Current Panel
* Tabs

You may enter your commands in the **Command Box** and then press Enter to execute them. The resulting message will be shown in the **Command Result Display** box.

The following describes what each panel contains:
* **Student List Panel:** Displays your students' details
* **Task List Panel:** Displays your tasks' details
* **Assignment List Panel:** Displays your students' assignment details
* **Sessions Panel:** Displays your sessions' details
* **Consultations Panel:** Displays your consultations' details


<br>

### Student Card
![Student Card with Annotations](images/StudentCardAnnotated.png)

<br>

### Task Card
![Task Card with Annotations](images/TaskCardAnnotated.png)

<br>

### Assignment Card
![Assignment Card with Annotations](images/AssignmentCardAnnotated.png)

<br>

### Session Card
![Session Card with Annotations](images/SessionCardAnnotated.png)

<br>

### Consultation Card
![Consultation Card with Annotations](images/ConsultationCardAnnotated.png)

<br>



--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have [Java 11](https://www.openlogic.com/openjdk-downloads?field_java_parent_version_target_id=406&field_operating_system_target_id=All&field_architecture_target_id=All&field_java_package_target_id=401) or above installed in your Computer.

2. Download the latest `fakejarvis.jar` from [here](https://github.com/AY2324S1-CS2103T-T15-1/tp/releases). _[Coming Soon]_

3. Copy the file to the folder you want to use as the _home folder_ for your F.A.K.E.J.A.R.V.I.S..

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar fakejarvis.jar` command to run the application.<br>
   A GUI similar to the image below should appear in a few seconds. (Currently, the image below is a mock-up of our GUI) Note how the app contains some sample data.<br>

    ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `viewtasks` : Lists all tasks.
    * `deletetask 3`: Deletes the 3rd task shown in the current task list.

    * `createconsult d/10/10/2023 tt/15:00 n/John Doe n/ Foo Bar` : Creates a consultation with the students `John Doe` and `Foo Bar`.

    * `createsession 3 n/John Doe` : Creates a `No. 3` Session with the student `John Doe`.

    * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command and the [Command Format](#command-format) for the specifications of each command.


[Back to Table of Contents](#table-of-contents)


--------------------------------------------------------------------------------------------------------------------


## Command Format

**The commands in the user guide adopt the following conventions:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `addtask tn/TASK_NAME`, `TASK_NAME` is a parameter which can be specified, such as `addtask tn/Do User Guide`.


* Items in square brackets are optional.<br>
  e.g `tn/TASK_NAME [td/do before feedback]` can be used as `tn/Do User Guide td/do before feedback` or as `tn/Do user Guide`.


* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[n/NAME]…​` can be used as ` ` (i.e. 0 times), `n/John Doe`, `n/John Doe n/ Foo Bar` etc.


* Parameters can be in any order.<br>
  e.g. if the command specifies `tn/TASK_NAME td/TASK_DESCRIPTION`, `td/TASK_DESCRIPTION tn/TASK_NAME` is also acceptable.


* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.


* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.

<br>

### Command Parameters
Most commands given in the user guide utilise various parameters which are also known as prefixes. To add a prefix to your command, follow this format: `PREFIX/MESSAGE`. Their prefixes and their respective constraints are given in the table below.


| Field               | Prefix   | Commands                                                                                                          | Description                                                                                                                                                                                                                                        |
|---------------------|----------|-------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| NAME                | `n/`     | `add` `edit` `addtoconsult` `createconsult` `removefromconsult` `createsession` `takeattendance` `viewattendance` | The Name of a student. <ul><li>Names should only contain alphanumeric characters and spaces.</li><li> Names should not be blank.</li></ul>                                                                                                         |
| PHONE               | `p/`     | `add` `edit`                                                                                                      | The Phone number of a student. <ul><li>Phone numbers should only contain numbers.</li><li> Numbers should be at least 3 digits.</li></ul>                                                                                                          |
| EMAIL               | `e/`     | `add` `edit`                                                                                                      | The Email of a student. <ul><li>Emails should be of the format `local-part@domain`</li><li>The local-part should only contain alphanumeric characters and these special characters `+_.-`</li><li>The domain name must be `@u.nus.edu`.</li> </ul> |
| TELEGRAM_HANDLE     | `th/`    | `add` `edit`                                                                                                      | The Telegram handle of a student. <ul><li>Telegram Handles can only use a-z, 0-9 and underscores.</li></ul>                                                                                                                                        |
| TAG                 | `t/`     | `add` `edit`                                                                                                      | The Tag belonging to a student. <ul><li>Tags should only contain alphanumeric characters. </li></ul>                                                                                                                                               |
| GRADED_TEST         | `gt/`    | `add` `edit`                                                                                                      | The scores of respective graded tests. <ul><li>Names should only contain alphanumeric characters and spaces. </li><li> Names should not be blank. </li></ul>                                                                                       |
| READING_ASSESSMENT1 | `ra1/`   | `editgradedtest`                                                                                                  | The score of Reading Assessment 1. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                            |
| READING_ASSESSMENT2 | `ra2/`   | `editgradedtest`                                                                                                  | The score of Reading Assessment 2. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                            |
| MIDTERMS            | `mt/`    | `editgradedtest`                                                                                                  | The score of a Midterms exam. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                                 |
| FINALS              | `f/`     | `editgradedtest`                                                                                                  | The score of a Finals exam. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                                   |
| PRACTICAL_EXAM      | `pe/`    | `editgradedtest`                                                                                                  | The score of a Practical exam. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                                |
| ASSIGNMENT          | `as/`    | `deletecomment` `editcomment` `editgrade`                                                                         | The name of an Assignment. <ul><li>Name should exist in the list of possible assignments.</li></ul>                                                                                                                                                |
| GRADE               | `g/`     | `editgrade`                                                                                                       | The grade of an Assignment. <ul><li>Grade should be a positive number.</li><li>Grade should be less than or equal to (max grade + 75).</li><li>Grade should not have leading 0's.</li></ul>                                                        |
| COMMENT             | `c/`     | `editcomment`                                                                                                     | The Comment of an Assignment. <ul><li>Comment should be less than 200 characters.</li><li>Comment should not be empty.</ul>                                                                                                                        |
| DATE                | `d/`     | `addtask` `viewtasks` `createconsult`                                                                             | The Date.  <ul><li>The format must be dd/MM/yyyy.</li></ul>                                                                                                                                                                                        |
| TIME                | `tt/`    | `createconsult`                                                                                                   | The Time. <ul><li>The format must be HH:mm.</li><li>Date must also be in 24-hour format.</li></ul>                                                                                                                                                 |
| SESSION             | `s/`     | `createsession` `deletesession` `takeattendance` `updatesessionremark`                                            | The Session Number of a Tutorial. <ul><li> Session must only contain numbers. </li><li>Session should not be blank.</li> </ul>                                                                                                                     |
| SESSION_REMARK      | `r/`     | `updatesessionremark`                                                                                             | The remarks of a Session. <ul><li> Remark must only contain alphanumeric characters and spaces. </li></ul>                                                                                                                                         |
| ATTENDANCE_PRESENCE | `ap/`    | `takeattendance`                                                                                                  | The presence of a student. <ul><li> Only 2 possible values are allowed: `PRESENT`, `ABSENT`. </li></ul>                                                                                                                                            |
| TASK_NAME           | `tn/`    | `addtask` `viewtasks`                                                                                             | The name of a Task. <ul><li> Name should only contain alphanumeric characters and spaces. </li><li>Name should not be blank.</li></ul>                                                                                                             |
| TASK_DESCRIPTION    | `td/`    | `addtask` `viewtasks`                                                                                             | The description of a Task. <ul><li> Description should be less than 100 characters. </li></ul>                                                                                                                                                     |
| TASK_PRIORITY       | `tp/`    | `addtask` `viewtasks`                                                                                             | The priority of a Task. <ul><li> Only 3 possible values are allowed: `HIGH`, `MEDIUM`, `LOW`. </li></ul>                                                                                                                                           |
| TASK_PROGRESS       | `tprog/` | `addtask` `viewtasks` `updateprogress`                                                                            | The progress of a Task. <ul><li> Only 3 possible values are allowed: `NOT_STARTED`, `PENDING`, `DONE`. </li></ul>                                                                                                                                  |


[Back to Table of Contents](#table-of-contents)

<br>

## Features
This section describes each of the commands and features available in F.A.K.E.J.A.R.V.I.S.

<br>

### General Commands
This section describes commands that fit in no special category.

<br>

#### Switching between different tabs: `tab`

You can navigate between different tabs in F.A.K.E.J.A.R.V.I.S.

Format: `tab INDEX`

| Parameter | Description                        |
|-----------|------------------------------------|
| INDEX     | The Index of the tab to switch to. |


<div class="alert alert-info">
<md>
:information_source: Note: 

* For the list of indexes to use:
* **Students List:** 1
* **Tasks List:** 2
* **Assignments List:** 3
* **Sessions List:** 4
* **Consultations List:** 5

</md> </div>

> **Example 1:**
>
> **Input:** `tab 1` Switches to the student list tab.
>
> **Output:**
>`Switched to tab 1`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `tab 2` Switches to the tasks list tab.
>
> **Output:**
>`Switched to tab 2`
>
> [IMAGE COMING SOON]
 
<br>

#### Viewing help : `help`

You can view a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


<br>

#### Exiting F.A.K.E.J.A.R.V.I.S. : `exit`

You can exit the F.A.K.E.J.A.R.V.I.S. application.

Format: `exit`


<br>

#### Saving the Data

F.A.K.E.J.A.R.V.I.S. data are saved in the hard disk automatically after any command that changes the data. There is no need to save data manually.


<br>

#### Editing the Data File

F.A.K.E.J.A.R.V.I.S. data are saved automatically as a JSON file `[JAR file location]/data/fakejarvis.json`. Advanced users are welcome to update data directly by editing that data file.

**Caution:**
If your changes to the data file makes its format invalid, F.A.K.E.J.A.R.V.I.S. will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>


<br>

#### Archiving Data Files `[coming in v2.0]`

_Stay tuned for more features and enhancements in `v2.0`, including archiving data files and more!_

[Back to Table of Contents](#table-of-contents)

<br>


### Student Management
This section describes commands that help you manage your students.

#### 📝Adding a Student: `add`

You can add a student to F.A.K.E.J.A.R.V.I.S.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL th/TELEGRAM_HANDLE [t/TAG]…​ [gt/GRADED_TESTS]`

| Parameter       | Description                                             |
|-----------------|---------------------------------------------------------|
| NAME            | The name of the student to be added.                    |
| PHONE_NUMBER    | The phone number of the student.                        |
| EMAIL           | The email address of the student.                       |
| TELEGRAM_HANDLE | The Telegram handle of the student.                     |
| TAG             | Tags associated with the student.                       |
| GRADED_TESTS    | Scores of the graded tests associated with the student. |

<div class="alert alert-info">
<md>
:information_source: Note: 

* You can add any number of tags to a student! (including 0)
* The format for `gt/` is `gt/RA1:0 | RA2:0 | MidTerms:0 | Finals:0 | PE:0`.
* You can use `gt/default` to set graded tests scores as '-' !

</md> </div>

> **Example 1:**
> 
> **Input:** `add n/John Doe p/98765432 e/johnd@u.nus.edu th/johnny01` Adds a person called John Doe into F.A.K.E.J.A.R.V.I.S. He has 98765432 as his phone number, johnd@u.nus.edu as his email and johnny01 as his telegram handle. 
> 
> **Output:**
>`New person added: Name: John Doe; Phone: 98765432; Email: johnd@u.nus.edu; Telegram Handle: johnny01; Tags: ; GradedTest: ;`
> 
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `add n/Betsy Crowe t/friend e/betsycrowe@u.nus.edu th/itsybetsyspider p/1234567 t/criminal` Adds a person called Betty Crowe into F.A.K.E.J.A.R.V.I.S. She has 1234567 as her phone number, betsycrowe@u.nus.edu as her email, itsybetsyspider as her telegram handle and criminal and friend as tags.
>
> **Output:**
>`New person added: Name: Betsy Crowe; Phone: 1234567; Email: betsycrowe@u.nus.edu; Telegram Handle: itsybetsyspider; Tags: ; Graded Test: [friend][criminal]; Graded Test: RA1: -; RA2: -; MidTerms: -; Final: -; PE: -`
>
> [IMAGE COMING SOON]


<br>

#### 👀Listing All Students : `list`

You can list out all students in F.A.K.E.J.A.R.V.I.S.

Format: `list`

> **Example 1:**
>
> **Input:** `list` Shows all the students currently in F.A.K.E.J.A.R.V.I.S.
>
> **Output:**
>`Listed all persons`
>
> [IMAGE COMING SOON]


<br>

#### 🛠️Editing a Student Field : `edit`

You can edit an existing student's fields in F.A.K.E.J.A.R.V.I.S.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [th/TELEGRAM_HANDLE] [t/TAG]…​ [gt/GRADED_TESTS]`

| Parameter       | Description                                             |
|-----------------|---------------------------------------------------------|
| INDEX           | The index of the student to be edited.                  |
| NAME            | The new name for the student.                           |
| PHONE           | The new phone number for the student.                   |
| EMAIL           | The new email address for the student.                  |
| TELEGRAM_HANDLE | The new Telegram handle for the student.                |
| TAG             | New tags associated with the student.                   |
| GRADED_TESTS    | Scores of the graded tests associated with the student. |


<div class="alert alert-info"><md> :information_source: Note: 

* Edits the person at the specified `INDEX`. 
* The index refers to the index number shown in the displayed student list. 
* The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided. (i.e NAME, PHONE, EMAIL, TELEGRAM_HANDLE, TAG, GRADED_TESTS)
* Editing tags overwrites existing tags; it's not cumulative.
* You can remove all the person’s tags by typing `t/` without specifying any tags after it.
* The format for `gt/` is `gt/RA1:0 | RA2:0 | MidTerms:0 | Finals:0 | PE:0`.
* You can use `gt/default` to reset graded tests scores as '-' !

</md>
</div>



> **Example 1:**
>
> **Input:** `edit 1 p/91234567 e/johndoe@u.nus.edu` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@u.nus.edu`.
>
> **Output:**
>`Edited Person: Name: Alex Yeoh; Phone: 91234567; Email: johndoe@u.nus.edu; Telegram Handle: alexYeohh; Tags: [friends]; Graded Test: RA1: 10; RA2: 10; MidTerms: 3; Final: 4; PE: 5`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
>
> **Output:**
>`Edited Person: Name: Betsy Crower; Phone: 99272758; Email: berniceyu@u.nus.edu; Telegram Handle: berrynice123; Tags: ; Graded Test: RA1: -; RA2: -; MidTerms: 3; Final: 4; PE: 5`
>
> [IMAGE COMING SOON]


<br>

#### 🔎Locating Student by Name: `find`

You can find a student whose name contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

| Parameter     | Description                         |
|---------------|-------------------------------------|
| KEYWORD       | The main keyword to search for.     |
| MORE_KEYWORDS | Additional keywords for the search. |



<div class="alert alert-info"> <md> :information_source: Note: 

* The search is case-insensitive. e.g `hans` will match `Hans`.
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
* Only full words will be matched e.g. `Han` will not match `Hans`.
* Persons matching at least one keyword will be returned (i.e. `OR` search). e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`.

</md>
</div>


> **Example 1:**
>
> **Input:** `find John` Finds students who have the `john` in their name.
>
> **Output:**
>`1 persons listed!`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `find alex david` Finds the students who have `alex` or `david` in their name.
>
> **Output:**
>`2 persons listed!`
>
> [IMAGE COMING SOON]


<br>

#### Deleting a Student : `delete`

You can delete a specific student from F.A.K.E.J.A.R.V.I.S.

Format: `delete INDEX`

| Parameter | Description                             |
|-----------|-----------------------------------------|
| INDEX     | The index of the student to be deleted. |


<div class="alert alert-info"> 
<md>

:information_source: Note: 

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

</md>
</div>

> **Example 1:**
>
> **Input:** `list` followed by `delete 2` Deletes the 2nd student in F.A.K.E.J.A.R.V.I.S.
>
> **Output:**
>`Deleted Person: Name: Bernice Yu; Phone: 99272758; Email: berniceyu@u.nus.edu; Telegram Handle: berrynice123; Tags: [colleagues][friends]; Graded Test: RA1: -; RA2: -; MidTerms: 3; Final: 4; PE: 5`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `find Betsy` followed by `delete 1` Deletes the 1st student in the results of the `find` command.
>
> **Output:**
>`Deleted Person: Name: Betsy Crowe; Phone: 1234567; Email: betsycrowe@u.nus.edu; Telegram Handle: itsybetsyspider; Tags: [friend][criminal]`
>
> [IMAGE COMING SOON]


<br>

#### Clearing all Entries : `clear`

You can clear all students from F.A.K.E.J.A.R.V.I.S.

Format: `clear`

> **Example 1:**
>
> **Input:** `clear` Deletes all students in F.A.K.E.J.A.R.V.I.S.
>
> **Output:**
>`Address book has been cleared!`
>
> [IMAGE COMING SOON]

[Back to Table of Contents](#table-of-contents)


<br>

### Task Management

This section describes commands that help you manage your tasks.

<br>

#### 📝Adding a Task: `addtask`

You can add a task to your task list.

Format: `addtask tn/TASK_NAME td/TASK_DESCRIPTION d/DUE_DATE tp/TASK_PRIORITY`

| Parameter        | Description                                                         |
|------------------|---------------------------------------------------------------------|
| TASK_NAME        | The name of the task.                                               |
| TASK_DESCRIPTION | The description of the task.                                        |
| DUE_DATE         | The due date or deadline of the task.                               |
| TASK_PRIORITY    | The priority level of the task. Given as `high`, `medium` or `low`. |


> **Example 1:**
>
> **Input:** `addtask tn/Prepare Lecture slides d/30/09/2023 tp/high` Creates a task to prepare lecture slides with a high priority due on September 30, 2023.
>
> **Output:**
>`Task has been added: Prepare Lecture slides; Description: No Description Provided; Priority: HIGH; Date: 2023-09-30; Progress: NOT_STARTED`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `addtask tn/Read Chapter 5` creates a task to read Chapter 5 without specifying a due date or priority.
>
> **Output:**
>`Task has been added: Read Chapter 5; Description: No Description Provided; Priority: LOW; Date: null; Progress: NOT_STARTED`
>
> [IMAGE COMING SOON]


<br>

#### 👀Viewing Tasks: `viewtasks`

You can view you list of tasks.

Format: `viewtasks [tn/TASK_NAME] / [td/TASK_DESCRIPTION] / [d/DUE_DATE] / [tp/TASK_PRIORITY] / [tprog/TASK_PROGRESS]`

| Parameter        | Description                                                                  |
|------------------|------------------------------------------------------------------------------|
| TASK_NAME        | The name of the task.                                                        |
| TASK_DESCRIPTION | The description of the task.                                                 |
| DUE_DATE         | The due date or deadline of the task.                                        |
| TASK_PRIORITY    | The priority level of the task. Given as `high`, `medium` or `low`.          |
| TASK_PROGRESS    | The progress level of the task. Given as `done`, `pending` or `not_started`. |
    

<div class="alert alert-info"> 
<md>

:information_source: Note:

* Only the task name, task description, due date, task priority and task progress are searched.
* Only one field can be searched at a time.
* The search is case-insensitive, e.g. `cs2101` will match `CS2101`.
* The order of the keywords does not matter, e.g. `quant book` will match `book quant`.
* If no task matching the search criteria is found, the resulting task list will be blank.

</md>
</div>


> **Example 1:**
>
> **Input:** `viewtasks` Displays all tasks in the user's task list.
>
> **Output:**
>`5 tasks listed!`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `viewtasks tp/high` Displays only high-priority tasks.
>
> **Output:**
>`4 tasks listed!`
>
> [IMAGE COMING SOON]


> **Example 3:**
>
> **Input:** `viewtasks d/30/09/2023` Displays tasks due on September 30, 2023.
>
> **Output:**
>`4 tasks listed!`
>
> [IMAGE COMING SOON]






<br>

#### 🛠️Updating a Task's Progress: `updateprogress`

You can mark a task as completed.

Format: `updateprogress TASK_INDEX tprog/NEW_PROGRESS`

| Parameter    | Description                                                                       |
|--------------|-----------------------------------------------------------------------------------|
| TASK_INDEX   | The index of the task to update the progress.                                     |
| NEW_PROGRESS | The new progress level of the task. Given as `done`, `pending`, or `not_started`. |



<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed task list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the task list.

</md>
</div>


> **Example 1:**
>
> **Input:** `updateprogress 1 tprog/pending` Updates the progress of the 1st task as pending.
>
> **Output:**
>`Updated Task: Do 2103T; Description: Homework assignment; Priority: HIGH; Date: 2023-10-22; Progress: PENDING`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `updateprogress 3 tprog/done` Updates the progress of the 3rd task as done.
>
> **Output:**
>`Updated Task: Do cs2100; Description: Remember mips; Priority: HIGH; Date: 2023-10-22; Progress: DONE`
>
> [IMAGE COMING SOON]


<br>

#### ❌Deleting a Task: `deletetask`

Deletes a task from the task list.

Format: `deletetask TASK_INDEX`

| Parameter  | Description                      |
|------------|----------------------------------|
| TASK_INDEX | The index of the task to delete. |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed task list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the task list.

</md>
</div>


> **Example 1:**
>
> **Input:** `deletetask 3` Deletes the 3rd task from the task list.
>
> **Output:**
>`Deleted Task: Do cs2100; Description: Remember mips; Priority: HIGH; Date: 2023-10-22; Progress: DONE`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `deletetask 2` Deletes the 2nd task from the task list.
>
> **Output:**
>`Deleted Task: Do cs2101; Description: Practice script; Priority: HIGH; Date: 2023-10-22; Progress: NOT_STARTED`
>
> [IMAGE COMING SOON]


[Back to Table of Contents](#table-of-contents)

<br>

### Attendance Management
This section describes commands that help you manage your students' attendance.


<br>

#### 📆Taking Attendance: `takeattendance`

You can take the attendance of your student(s).

Format: `takeattendance n/STUDENT_NAME s/SESSION_NUMBER ap/PRESENCE`


| Parameter      | Description                                                           |
|----------------|-----------------------------------------------------------------------|
| STUDENT_NAME   | The name of the student.                                              |
| SESSION_NUMBER | The session number of the session.                                    |
| PRESENCE       | The attendance status of the student. Given as `present` or `absent`. |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `takeattendance n/Alex Yeoh s/2 ap/present` Marks Alex Yeoh as present on the 5th session.
>
> **Output:**
>`Attendance taken`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `takeattendance n/David Li s/2 ap/absent` Marks David Li as absent on the 2nd session.
>
> **Output:**
>`Attendance taken`
>
> [IMAGE COMING SOON]


<br>

#### 👀Viewing Attendance: `viewattendance`

You can view the attendance list of your students.

Format: `viewattendance n/STUDENT_NAME [MORE_STUDENT_NAMES]`

| Parameter    | Description                                                    |
|--------------|----------------------------------------------------------------|
| STUDENT_NAME | The name of the student(s) you want to view the attendance of. |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>


> **Example 1:**
>
> **Input:** `viewattendance` Displays the overall attendance across all students and sessions.
>
> **Output:**
>`2 sessions listed!`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `viewattendance n/Alex` Displays all the sessions that Alex has attended.
>
> **Output:**
>`2 sessions listed!`
>
> [IMAGE COMING SOON]


> **Example 3:**
>
> **Input:** `viewattendance n/Bernice Alex` Displays all the sessions that Bernice and Alex have attended.
>
> **Output:**
>`2 sessions listed!`
>
> [IMAGE COMING SOON]


[Back to Table of Contents](#table-of-contents)

<br>

### Assignment Management
This section describes commands that help you manage your students' assignments.

<br>

#### 👀Viewing a List of Assignments: `viewassignments`

You can view a list of assignment grades and comments.

Format: `viewassignments INDEX`

| Parameter | Description               |
|-----------|---------------------------|
| INDEX     | The index of the student. |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.

</md>
</div>

> **Example 1:**
>
> **Input:** `viewassignments 1` Shows a list of the 1st student's assignment names, grades and comments.
>
> **Output:**
>`Showing all assignment details of: Alex Yeoh`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `viewassignments 2` shows a list of the 2nd student's assignment names, grades and comments.
>
> **Output:**
>`Showing all assignment details of: Betsy Crower`
>
> [IMAGE COMING SOON]


<br>

#### 🛠️Editing an Assignment Grade: `editgrade`

You can edit your student’s assignment grade.

Format: `editgrade INDEX as/ASSIGNMENT g/GRADE`

| Parameter  | Description                 |
|------------|-----------------------------|
| INDEX      | The index of the student.   |
| ASSIGNMENT | The name of the assignment. |
| GRADE      | The score of the student.   |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.
* The name of the assignment must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `editgrade 1 as/Functional Expressionism g/500` Edits the grade of the 1st student's Functional Expressionism assignment to 500.
>
> **Output:**
>`Edited grade to assignment: Functional Expressionism`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `editgrade 2 as/Rune Reading g/300` edits the grade of the 2nd student's Rune Reading assignment to 300.
>
> **Output:**
>`Edited grade to assignment: Rune Reading`
>
> [IMAGE COMING SOON]



<br>

#### ❌Deleting an Assignment Grade: `deletegrade`

You can delete your student’s assignment grade.

Format: `deletegrade INDEX as/ASSIGNMENT`

| Parameter  | Description                 |
|------------|-----------------------------|
| INDEX      | The index of the student.   |
| ASSIGNMENT | The name of the assignment. |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.
* The name of the assignment must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>


> **Example 1:**
>
> **Input:** `deletegrade 1 as/Functional Expressionism` deletes the 1st student's Functional Expressionism grade if its graded.
>
> **Output:**
>`Deleted grade from assignment: Functional Expressionism`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `deletegrade 2 as/Rune Reading` deletes the 2nd student's Rune Reading grade if its graded.
>
> **Output:**
>`Deleted grade from assignment: Rune Reading`
>
> [IMAGE COMING SOON]



<br>

#### 🛠️Editing an Assignment Comment: `editcomment`

You can edit the comment of your student’s assignment.

Format: `editcomment INDEX as/ASSIGNMENT c/COMMENT`

| Parameter  | Description                 |
|------------|-----------------------------|
| INDEX      | The index of the student.   |
| ASSIGNMENT | The name of the assignment. |
| COMMENT    | The new comment.            |



<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.
* The name of the assignment must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
> 
> **Input:** `editcomment 1 as/Functional Expressionism c/Decent` Changes the comment on the 1st student's Functional Expressionism assignment to “Decent”.
>
> **Output:**
>`Edited comment to assignment: Functional Expressionism`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `editcomment 2 as/Rune Reading c/Great` Changes the comment on the 2nd student's Rune Reading assignment to “Great”.
>
> **Output:**
>`Edited comment to assignment: Rune Reading`
>
> [IMAGE COMING SOON]




<br>

#### ❌Deleting an Assignment Comment: `deletecomment`

You can delete the comment tagged to your student’s assignment.

Format: `deletecomment INDEX as/ASSIGNMENT`

| Parameter  | Description                 |
|------------|-----------------------------|
| INDEX      | The index of the student.   |
| ASSIGNMENT | The name of the assignment. |



<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.
* The name of the assignment must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `deletecomment 1 as/Functional Expressionism` Deletes the comment on the 1st student's Functional Expressionism assignment if it exists.
>
> **Output:**
>`Deleted comment from assignment: Functional Expressionism`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `deletecomment 2 as/Rune Reading` Deletes the comment on the 2nd student's Rune Reading assignment if it exists.
>
> **Output:**
>`Deleted comment from assignment: Rune Reading`
>
> [IMAGE COMING SOON]



[Back to Table of Contents](#table-of-contents)


<br>

### Graded Test Management
This section describes commands tht help you manage your students' graded tests.


<br>

#### 🛠️Editing a Graded Test Score: `editgradedtest`

You can edit your student’s graded test scores.

Format: `editgrade INDEX ra1/READING_ASSESSMENT_1 ra2/READING_ASSESSMENT_2 mt/MIDTERMS f/FINALS pe/PRACTICALEXAM `

| Parameter            | Description                                      |
|----------------------|--------------------------------------------------|
| INDEX                | The index of the student.                        |
| READING_ASSESSMENT_1 | The score of the student's Reading Assessment 1. |
| READING_ASSESSMENT_2 | The score of the student's Reading Assessment 2. |
| MIDTERMS             | The score of the student's MidTerms.             |
| FINALS               | The score of the student's Final Assessment.     |
| PRACTICALEXAM        | The score of the student's Practical Exams.      |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.

</md>
</div>


> **Example 1:**
>
> **Input:** `editgradedtest 1 ra1/1 ra2/2 mt/3 f/4 pe/5` Edits the corresponding graded test scores for the 1st person Alex Yeoh. 
>
> **Output:**
>`Edited Person: Name: Alex Yeoh; Phone: 91234567; Email: johndoe@u.nus.edu; Telegram Handle: alexYeohh; Tags:[friends]; Graded Test: RA1: 1; RA2: 2; MidTerms: 3; Final: 4; PE: 5`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `editgradedtest 1 ra1/100 f/100 ` Edits the corresponding graded test scores for the 1st 
> person Alex Yeoh.
>
> **Output:**
>`Edited Person: Name: Alex Yeoh; Phone: 91234567; Email: johndoe@u.nus.edu; Telegram Handle: alexYeohh; Tags:
> [friends]; Graded Test: RA1: 100; RA2: 2; MidTerms: 3; Final: 4; PE: 100`
> 
> [IMAGE COMING SOON]


[Back to Table of Contents](#table-of-contents)


<br>

### Session Management
This section describes commands that help you manage your sessions.


<br>

#### 📝Creating a Session: `createsession`

You can create a session for any upcoming or past sessions.

Format: `createsession s/SESSION_NUMBER n/STUDENT_NAME n/STUDENT_NAME …`

| Parameter      | Description                        |
|----------------|------------------------------------|
| SESSION_NUMBER | The session number of the session. |
| STUDENT_NAME   | The name of the student(s).        |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The name of the student must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `createsession s/3 n/Alex Yeoh` Creates a session, which has session number 3 with Alex Yeoh.
>
> **Output:**
>`New session added: Session: 3; Students: Alex Yeoh; Remark: NA`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `createsession s/4 n/Betsy Crower n/David Li` Creates a session, which has session number 3, with Betsy Crower and David Li.
>
> **Output:**
>`New session added: Session: 4; Students: Betsy CrowerDavid Li; Remark: NA`
>
> [IMAGE COMING SOON]


<br>


#### 🛠️Updating a Session's Remark: `updatesessionremark`

You can update an existing session's remark.

Format: `updatesessionremark s/SESSION_NUMBER r/REMARK`

| Parameter      | Description                                   |
|----------------|-----------------------------------------------|
| SESSION_NUMBER | The session number of the session.            |
| REMARK         | The new remark to be updated for the session. |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The session number must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `updatesessionremark s/2 r/Teach Essence of Recursion` Updates the remark for session number 2 to "Teach Essence of Recursion".
>
> **Output:**
>`Session remarks updated: Session: 2; Students: Bernice YuCharlotte OliveiroAlex YeohIrfan IbrahimRoy Balakrishnan; Remark: Teach Essence of Recursion`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `updatesessionremark s/4 r/Taught streams and metacircular evalutator` Updates the remark for session 4 to "Taught streams and metacircular evaluator".
>
> **Output:**
>`Session remarks updated: Session: 4; Students: Betsy CrowerDavid Li; Remark: Taught streams and metacircular evalutator`
>
> [IMAGE COMING SOON]


<br>


#### ❌Deleting a Session: `deletesession`

You can delete an existing session specified by its session number.

Format: `deletesession s/SESSION_NUMBER`

| Parameter      | Description                        |
|----------------|------------------------------------|
| SESSION_NUMBER | The session number of the session. |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The session number must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>


> **Example 1:**
>
> **Input:** `deletesession s/1` Deletes the session with session number 1 from the session list.
>
> **Output:**
>`Deleted Session: Session: 1; Students: Bernice YuCharlotte OliveiroDavid LiAlex YeohIrfan IbrahimRoy Balakrishnan; Remark: NA`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `deletesession s/4` Deletes the session with session number 4 from the session list.
>
> **Output:**
>`Deleted Session: Session: 4; Students: Betsy CrowerDavid Li; Remark: Taught streams and metacircular evalutator`
>
> [IMAGE COMING SOON]


<br>

### Consultation Management
This section describes commands that help you manage your consultations with students.


<br>

#### 📝Creating a Consultation: `createconsult`

You can create a consultation for any upcoming consultations.

Format: `createconsult d/DATE tt/TIME n/STUDENT_NAME n/STUDENT_NAME …`

| Parameter    | Description                 |
|--------------|-----------------------------|
| DATE         | The date of consultation.   |
| TIME         | The time of consultation.   |
| STUDENT_NAME | The name of the student(s). |



<div class="alert alert-info"> 
<md>

:information_source: Note:

* The name of the students must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `createconsult d/30/10/2023 tt/12:30 n/Alex Yeoh` Creates a consultation for Alex Yeoh on 2023-10-30 12:30.
>
> **Output:**
>`New consultation added: ; Date: 2023-10-30; Time: 12:30; Students: Alex Yeoh`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `createconsult d/30/09/2023 tt/15:30 n/Alex Yeoh n/Betsy Crower n/David Li` Creates a consultation for Alex Yeoh, Betsy Crower and David Li on 2023-09-30 15:30.
>
> **Output:**
>`New consultation added: ; Date: 2023-09-30; Time: 15:30; Students: Betsy CrowerDavid LiAlex Yeoh`
>
> [IMAGE COMING SOON]


<br>

#### 📝️Adding students to a consultation: `addtoconsult`
You can add your student(s) into a consultation slot.

Format: `addtoconsult INDEX n/STUDENT_NAME …`

| Parameter    | Description                                                  |
|--------------|--------------------------------------------------------------|
| INDEX        | The index of the consultation in the upcoming consultations. |
| STUDENT_NAME | The name of the student to be added to the consultation.     |



<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed consultation list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the consultation list.
* The name of the student must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `addtoconsult 2 n/Betsy Crower` Adds Betsy Crower to the 2nd consultation on the list.
>
> **Output:**
>`New student(s) added to consultation at index ; Date: 2023-11-01; Time: 10:00; Students: Betsy CrowerAlex Yeoh: ; Date: 2023-11-01; Time: 10:00; Students: Betsy CrowerAlex Yeoh`
>
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `addtoconsult 1 n/David Li n/Roy Balakrishnan` Adds David Li and Roy Balakrishnan to the 1st consultation in the list.
>
> **Output:**
>`New student(s) added to consultation at index ; Date: 2023-11-11; Time: 11:11; Students: Bernice YuDavid LiAlex YeohRoy Balakrishnan: ; Date: 2023-11-11; Time: 11:11; Students: Bernice YuDavid LiAlex YeohRoy Balakrishnan`
>
> [IMAGE COMING SOON]


<br>

#### ❌Removing Students from a Consultation: `removefromconsult`

You can remove your student(s) from a consultation.

Format: `removefromconsult INDEX n/STUDENT_NAME …`

| Parameter    | Description                                                  |
|--------------|--------------------------------------------------------------|
| INDEX        | The index of the consultation in the upcoming consultations. |
| STUDENT_NAME | The name of the student to be added to the consultation.     |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed consultation list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the consultation list.
* The name of the student must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `removefromconsult 2 n/Betsy Crower` Removes Betsy Crower from the 2nd consultation in the list.
>
> **Output:**
>`Student(s) removed from consultation at index ; Date: 2023-11-01; Time: 10:00; Students: Alex Yeoh: ; Date: 2023-11-01; Time: 10:00; Students: Alex Yeoh`
>
> [IMAGE COMING SOON]


<br>

#### ❌Deleting a Consultation: `deleteconsult`

You can delete the consultation slot specified by an index.

Format: `deleteconsult INDEX`

| Parameter | Description                                                  |
|-----------|--------------------------------------------------------------|
| INDEX     | The index of the consultation in the upcoming consultations. |


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The index refers to the index number shown in the displayed consultation list.
* The index **must be a positive integer** 1, 2, 3, …​ that is within the range of the consultation list.

</md>
</div>

> **Example 1:**
>
> **Input:** `deleteconsult 1` Deletes the 1st consultation in the consultation list.
>
> **Output:**
>`Deleted Consultation: ; Date: 2023-11-11; Time: 11:11; Students: Bernice YuAlex YeohRoy Balakrishnan`
>
> [IMAGE COMING SOON]

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous F.A.K.E.J.A.R.V.I.S. home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| **Action**                    | **Format**                                                                                                     | **Examples**                                                                                                                   |
|-------------------------------|----------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| **Add**                       | `add n/NAME p/PHONE_NUMBER e/EMAIL th/TELEGRAM_HANDLE [t/TAG]...[gt/GRADEDTEST]…​`                             | `add n/James Ho p/22224444 e/jamesho@u.nus.edu th/james03 t/friend t/colleague gt/default`                                     |
| **Clear**                     | `clear`                                                                                                        | `clear`                                                                                                                        |
| **Delete**                    | `delete INDEX`                                                                                                 | `delete 3`                                                                                                                     |
| **Edit**                      | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [th/TELGRAM_HANDLE] [t/TAG]…[gt/GRADEDTEST]…`                  | `edit 2 n/James Lee e/jameslee@u.nus.edu gt/default`                                                                           |
| **Find**                      | `find KEYWORD [MORE_KEYWORDS]`                                                                                 | `find John` or `find alex david`                                                                                               |
| **View**                      | `viewtasks [tn/TASK_NAME] / [td/TASK_DESCRIPTION] / [d/DUE_DATE] / [tp/TASK_PRIORITY] / [tprog/TASK_PROGRESS]` | `viewtasks`, `viewtasks tp/high`, `viewtasks d/30/09/2023`                                                                     |
| **Update Progress**           | `updateprogress TASK_INDEX tprog/NEW_PROGRESS`                                                                 | `updateprogress 1 tprog/pending`, `updateprogress 3 tprog/done`                                                                |
| **Delete Task**               | `deletetask TASK_INDEX`                                                                                        | `deletetask 3`, `deletetask 2`                                                                                                 |
| **Take Attendance**           | `takeattendance n/STUDENT_NAME s/SESSION p/PRESENCE`                                                           | `takeattendance n/John Doe s/5 present`, `takeattendance n/Foo Bar s/2 absent`                                                 |
| **View Attendance**           | `viewattendance n/STUDENT_NAME [MORE_STUDENT_NAMES]`                                                           | `viewattendance`, `viewattendance n/Rayan`, `viewattendance n/Jayson Resley`                                                   |
| **Add Grade**                 | `addgrade INDEX as/ASSIGNMENT g/GRADE`                                                                         | `addgrade 1 as/Functional Expressionism g/1300`, `addgrade 2 as/Rune Reading g/600`                                            |
| **View Grade**                | `viewgrade INDEX as/ASSIGNMENT`                                                                                | `viewgrade 1 as/Functional Expressionism`, `viewgrade 2 as/Rune Reading`                                                       |
| **Edit Grade**                | `editgrade INDEX as/ASSIGNMENT g/GRADE`                                                                        | `editgrade 1 as/Functional Expressionism g/1200`, `editgrade 2 as/Rune Reading g/1000`                                         |
| **Delete Grade**              | `deletegrade INDEX as/ASSIGNMENT`                                                                              | `deletegrade 1 as/Functional Expressionism`, `deletegrade 2 as/Rune Reading`                                                   |
| **Add Comment**               | `addcomment n/STUDENT_NAME a/ASSIGNMENT c/COMMENT`                                                             | `addcomment n/Rayson a/Functional Expressionism c/Excellent`, `addcomment n/Wesley a/Rune Reading c/Not bad`                   |
| **View Comment**              | `viewcomment n/STUDENT_NAME a/ASSIGNMENT`                                                                      | `viewcomment n/Rayson a/Functional Expressionism`, `viewcomment n/Wesley a/Rune Reading`                                       |
| **Edit Comment**              | `editcomment n/STUDENT_NAME a/ASSIGNMENT c/COMMENT`                                                            | `editcomment n/Rayson a/Functional Expressionism c/Decent`, `editcomment n/Wesley a/Rune Reading c/Great`                      |
| **Delete Comment**            | `deletecomment n/STUDENT_NAME a/ASSIGNMENT`                                                                    | `deletecomment n/Rayson a/Functional Expressionism`, `deletecomment n/Wesley a/Rune Reading`                                   |
| **Edit Graded Test**          | `editgradedtest INDEX ra1/READING_ASSESSMENT_1 ra2/READING_ASSESSMENT_2 mt/MIDTERMS f/FINALS pe/PRACTICALEXAM` | `editgradedtest 1 ra1/90 ra2/80 mt/85 f/88 pe/95`, `editgradedtest 2 ra1/88 ra2/92 mt/78 f/80 pe/89`                           |
| **Create Consultation**       | `createconsult d/DATE tt/TIME n/STUDENT_NAME n/STUDENT_NAME …`                                                 | `createconsult d/2023-10-30 tt/12:30 n/John Doe`, `createconsult d/2023-09-30 tt/15:30 n/John Doe n/Foo Bar n/Rayson n/Wesley` |
| **Show Consultations**        | `showconsults`                                                                                                 | `showconsults`                                                                                                                 |
| **View Consultation Details** | `viewconsult INDEX`                                                                                            | `viewconsult 1`, `viewconsult 2`                                                                                               |

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Encountering Errors
This section outlines a list of error messages that you may encounter during your usage of the application. It aims to help you better understand the messages that you may receive and what it means to you.

_[Coming soon]_
