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

<br>
<br>
<!-- * Table of Contents -->
<page-nav-print />

<br>

### Table of Contents

&nbsp;1 [Introduction](#introduction)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.1 [Table of Contents](#table-of-contents)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.2 [How to use the User Guide](#how-to-use-the-user-guide)  
&nbsp;2 [Graphical User Interface](#graphical-user-interface)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.1 [Task Card](#task-card)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.2 [Consultation Card](#consultation-card)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.3 [Session Card](#session-card)  
&nbsp;3 [Quick Start](#quick-start)  
&nbsp;4 [Command Format](#command-format)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.1 [Command Parameters](#command-parameters)  
&nbsp;5 [Features](#features)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.1 [General Commands](#general-commands)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.1.1 [Viewing help : `help`](#viewing-help-help)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.1.2 [Exiting F.A.K.E.J.A.R.V.I.S. : `exit`](#exiting-f-a-k-e-j-a-r-v-i-s-exit)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.1.3 [Saving the Data](#saving-the-data)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.1.4 [Editing the Data File](#editing-the-data-file)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.1.5 [Archiving Data Files `[coming in v2.0]`](#archiving-data-files-coming-in-v2-0)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2 [Student Management](#student-management)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.1 [Adding a Student: `add`](#adding-a-student-add)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.2 [Listing All Students : `list`](#listing-all-students-list)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.3 [Editing a Student Field : `edit`](#editing-a-student-field-edit)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.4 [Locating Student by Name: `find`](#locating-student-by-name-find)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.5 [Deleting a Student : `delete`](#deleting-a-student-delete)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.6 [Clearing all Entries : `clear`](#clearing-all-entries-clear)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3 [Task Management](#task-management)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3.1 [Adding a Task: `addtask`](#adding-a-task-addtask)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3.2 [Viewing Tasks: `viewtasks`](#viewing-tasks-viewtasks)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3.3 [Updating a Task's Progress: `updateprogress`](#updating-a-task-s-progress-updateprogress)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3.4 [Deleting a Task: `deletetask`](#deleting-a-task-deletetask)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.4 [Attendance Management](#attendance-management)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.4.1 [Taking Attendance: `takeattendance`](#taking-attendance-takeattendance)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.4.2 [Viewing Attendance: `viewattendance`](#viewing-attendance-viewattendance)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.5 [Assignment Management](#assignment-management)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.5.1 [Viewing a list of Assignments: `viewassignments`](#viewing-a-list-of-assignments-viewassignments)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.5.2 [Editing an Assignment Grade: `editgrade`](#editing-an-assignment-grade-editgrade)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.5.3 [Deleting an Assignment Grade: `deletegrade`](#deleting-an-assignment-grade-deletegrade)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.5.4 [Editing an Assignment Comment: `editcomment`](#editing-an-assignment-comment-editcomment)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.5.5 [Deleting an Assignment Comment: `deletecomment`](#deleting-an-assignment-comment-deletecomment)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.6 [Graded Test Management](#graded-test-management)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.6.1 [Editing a Graded Test Score: `editgradedtest`](#editing-a-graded-test-score-editgradedtest)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.7 [Session Management](#session-management)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.7.1 [Creating a Session: `createsession`](#creating-a-session-createsession)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.7.2 [Updating a Session's Remark: `updatesessionremark`](#updating-a-session-s-remark-updatesessionremark)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.7.3 [Deleting a Session: `deletesession`](#deleting-a-session-deletesession)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.8 [Consultation Management](#consultation-management)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.8.1 [Creating a Consultation: `createconsult`](#creating-a-consultation-createconsult)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.8.2 [Adding students to a consultation: `addtoconsult`](#adding-students-to-a-consultation-addtoconsult)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.8.3 [Removing Students from a Consultation: `removefromconsult`](#removing-students-from-a-consultation-removefromconsult)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.8.4 [Deleting a Consultation: `deleteconsult`](#deleting-a-consultation-deleteconsult)  
&nbsp;6 [FAQ](#faq)  
&nbsp;7 [Known Issues](#known-issues)  
&nbsp;8 [Command Summary](#command-summary)  
&nbsp;9 [Encountering Errors](#encountering-errors)



<br>
<br>

### How to use the User Guide
You may refer to the **Table of Contents** on the right for easy navigation of the User Guide.

The F.A.K.E.J.A.R.V.I.S. User Guide employs a variety of visual cues to enhance the information it presents. The table below offers an overview of the typographical conventions used.

<br>


| <center>**Convention**</center> | <center>**Description**</center>                                                |
|---------------------------------|---------------------------------------------------------------------------------|
| <center>`Monospace`</center>    | <center>Used for command inputs, syntax, and file paths.</center>               |
| <center>**Bold text**</center>  | <center>Highlights important keywords.</center>                                 |
| <center>[Hyperlink](#)</center> | <center>Indicates hyperlinks to external websites or within the guide.</center> |


<br>


| <center>**Convention**</center>                                                                      | <center>**Description**</center>                                                 |
|------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| <center>**<div markdown="span" class="alert alert-info"> :information_source: Note </div>**</center> | <center>Provides information of special interest or importance.</center>         |
| <center>**<div markdown="span" class="alert alert-warning"> :bangbang: Warning </div>**</center>     | <center>Alerts to potentially irreversible actions with data loss risk.</center> |


<br>


| <center>**Convention**</center> | <center>**Description**</center>               |
|---------------------------------|------------------------------------------------|
| <center>📝</center>             | <center>Add <br/> Create</center>              |
| <center>❌</center>              | <center>Delete <br/> Remove</center></center>  |
| <center>🛠️</center>            | <center>Edit <br/> Modify <br/> Update         |
| <center>🔎</center>             | <center>Find</center>                          |
| <center>📆</center>             | <center>Take Attendance</center>               |
| <center>👀</center>             | <center>View <br/> Display </br> List</center> |



[Back to Table of Contents](#table-of-contents)

<br>

--------------------------------------------------------------------------------------------------------------------

<br>

## Graphical User Interface

![UI with Annotations](images/newUiWithAnnotations.png)

F.A.K.E.J.A.R.V.I.S.'s graphical user interface (GUI) consists of 4 main components:
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
<br>

### Student Card
![Student Card with Annotations](images/StudentCardAnnotated.png)

<br>
<br>

### Task Card
![Task Card with Annotations](images/TaskCardAnnotated.png)

<br>
<br>

### Assignment Card
![Assignment Card with Annotations](images/AssignmentCardAnnotated.png)

<br>
<br>

### Session Card
![Session Card with Annotations](images/SessionCardAnnotated.png)

<br>
<br>

### Consultation Card
![Consultation Card with Annotations](images/ConsultationCardAnnotated.png)

<br>

--------------------------------------------------------------------------------------------------------------------

<br>

## Quick start

1. Ensure you have [Java 11](https://www.openlogic.com/openjdk-downloads?field_java_parent_version_target_id=406&field_operating_system_target_id=All&field_architecture_target_id=All&field_java_package_target_id=401) or above installed in your Computer.

2. Download the latest `fakejarvis.jar` from [here](https://github.com/AY2324S1-CS2103T-T15-1/tp/releases). _[Coming Soon]_

3. Copy the file to the folder you want to use as the _home folder_ for your F.A.K.E.J.A.R.V.I.S..

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar fakejarvis.jar` command to run the application.<br>
   A GUI similar to the image below should appear in a few seconds. Note how the app contains some sample data.<br>

    ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `viewtasks` : Lists all tasks.
    * `deletetask 3`: Deletes the 3rd task shown in the current task list.

    * `createconsult d/10/10/2023 tt/15:00 n/John Doe n/ Foo Bar` : Creates a consultation with the students `John Doe` and `Foo Bar`.

    * `createsession s/3 n/John Doe` : Creates a session with session number 3 with the student `John Doe`.

    * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command and the [Command Format](#command-format) for the specifications of each command.


[Back to Table of Contents](#table-of-contents)

<br>

--------------------------------------------------------------------------------------------------------------------


<br>

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
<br>

### Command Parameters
Most commands given in the user guide utilise various parameters which are also known as prefixes. To add a prefix to your command, follow this format: `PREFIX/MESSAGE`. Their prefixes and their respective constraints are given in the table below.


| <center>**Field**</center>            | <center>**Prefix**</center> | <center>**Commands**</center>                                                                                     | <center>**Description**</center>                                                                                                                                                                                                                   |
|---------------------------------------|-----------------------------|-------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <center>NAME</center>                 | <center>`n/`</center>       | `add` `edit` `addtoconsult` `createconsult` `removefromconsult` `createsession` `takeattendance` `viewattendance` | The Name of a student. <ul><li>Names should only contain alphanumeric characters and spaces.</li><li> Names should not be blank.</li></ul>                                                                                                         |
| <center>PHONE</center>                | <center>`p/`</center>       | `add` `edit`                                                                                                      | The Phone number of a student. <ul><li>Phone numbers should only contain numbers.</li><li> Numbers should be at least 3 digits.</li></ul>                                                                                                          |
| <center>EMAIL</center>                | <center>`e/`</center>       | `add` `edit`                                                                                                      | The Email of a student. <ul><li>Emails should be of the format `local-part@domain`</li><li>The local-part should only contain alphanumeric characters and these special characters `+_.-`</li><li>The domain name must be `@u.nus.edu`.</li> </ul> |
| <center>TELEGRAM_HANDLE</center>      | <center>`th/`</center>      | `add` `edit`                                                                                                      | The Telegram handle of a student. <ul><li>Telegram Handles can only use a-z, 0-9 and underscores.</li></ul>                                                                                                                                        |
| <center>TAG</center>                  | <center>`t/`</center>       | `add` `edit`                                                                                                      | The Tag belonging to a student. <ul><li>Tags should only contain alphanumeric characters. </li></ul>                                                                                                                                               |
| <center>GRADED_TEST</center>          | <center>`gt/`</center>      | `add` `edit`                                                                                                      | The scores of respective graded tests. <ul><li>Names should only contain alphanumeric characters and spaces. </li><li> Names should not be blank. </li></ul>                                                                                       |
| <center>READING_ASSESSMENT_1</center> | <center>`ra1/`</center>     | `editgradedtest`                                                                                                  | The score of Reading Assessment 1. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                            |
| <center>READING_ASSESSMENT_2</center> | <center>`ra2/`</center>     | `editgradedtest`                                                                                                  | The score of Reading Assessment 2. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                            |
| <center>MIDTERMS</center>             | <center>`mt/`</center>      | `editgradedtest`                                                                                                  | The score of a Midterms exam. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                                 |
| <center>FINALS</center>               | <center>`f/`</center>       | `editgradedtest`                                                                                                  | The score of a Finals exam. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                                   |
| <center>PRACTICAL_EXAM</center>       | <center>`pe/`</center>      | `editgradedtest`                                                                                                  | The score of a Practical exam. <ul><li>Score should be a positive number.</li></ul>                                                                                                                                                                |
| <center>ASSIGNMENT</center>           | <center>`as/`</center>      | `deletecomment` `editcomment` `editgrade`                                                                         | The name of an Assignment. <ul><li>Name should exist in the list of possible assignments.</li></ul>                                                                                                                                                |
| <center>GRADE</center>                | <center>`g/`</center>       | `editgrade`                                                                                                       | The grade of an Assignment. <ul><li>Grade should be a positive number.</li><li>Grade should be less than or equal to (max grade + 75).</li><li>Grade should not have leading 0's.</li></ul>                                                        |
| <center>COMMENT</center>              | <center>`c/`</center>       | `editcomment`                                                                                                     | The Comment of an Assignment. <ul><li>Comment should be less than 200 characters.</li><li>Comment should not be empty.</ul>                                                                                                                        |
| <center>DATE</center>                 | <center>`d/`</center>       | `addtask` `viewtasks` `createconsult`                                                                             | The Date.  <ul><li>The format must be dd/MM/yyyy.</li></ul>                                                                                                                                                                                        |
| <center>TIME</center>                 | <center>`tt/`</center>      | `createconsult`                                                                                                   | The Time. <ul><li>The format must be HH:mm.</li><li>Time must also be in 24-hour format.</li></ul>                                                                                                                                                 |
| <center>SESSION</center>              | <center>`s/`</center>       | `createsession` `deletesession` `takeattendance` `updatesessionremark`                                            | The Session Number of a Tutorial. <ul><li> Session must only contain numbers. </li><li>Session should not be blank.</li> </ul>                                                                                                                     |
| <center>SESSION_REMARK</center>       | <center>`r/`</center>       | `updatesessionremark`                                                                                             | The remarks of a Session. <ul><li> Remark must only contain alphanumeric characters and spaces. </li></ul>                                                                                                                                         |
| <center>ATTENDANCE_PRESENCE</center>  | <center>`ap/`</center>      | `takeattendance`                                                                                                  | The presence of a student. <ul><li> Only 2 possible values are allowed: `PRESENT`, `ABSENT`. </li></ul>                                                                                                                                            |
| <center>TASK_NAME</center>            | <center>`tn/`</center>      | `addtask` `viewtasks`                                                                                             | The name of a Task. <ul><li> Name should only contain alphanumeric characters and spaces. </li><li>Name should not be blank.</li></ul>                                                                                                             |
| <center>TASK_DESCRIPTION</center>     | <center>`td/`</center>      | `addtask` `viewtasks`                                                                                             | The description of a Task. <ul><li> Description should be less than 100 characters. </li></ul>                                                                                                                                                     |
| <center>TASK_PRIORITY</center>        | <center>`tp/`</center>      | `addtask` `viewtasks`                                                                                             | The priority of a Task. <ul><li> Only 3 possible values are allowed: `HIGH`, `MEDIUM`, `LOW`. </li></ul>                                                                                                                                           |
| <center>TASK_PROGRESS</center>        | <center>`tprog/`</center>   | `addtask` `viewtasks` `updateprogress`                                                                            | The progress of a Task. <ul><li> Only 3 possible values are allowed: `NOT_STARTED`, `PENDING`, `DONE`. </li></ul>                                                                                                                                  |


[Back to Table of Contents](#table-of-contents)

<br>

--------------------------------------------------------------------------------------------------------------------


<br>

## Features
This section describes each of the commands and features available in F.A.K.E.J.A.R.V.I.S.

<br>
<br>

### General Commands
This section describes commands that fit in no special category.

<br>
<br>

#### Switching between different tabs: `tab`

You can navigate between different tabs in F.A.K.E.J.A.R.V.I.S.

Format: `tab TAB_INDEX`

| <center>**Parameter**</center> | <center>**Description**</center>                    |
|--------------------------------|-----------------------------------------------------|
| <center>TAB_INDEX</center>     | <center>The Index of the tab to switch to.</center> |
<br>

<div class="alert alert-info">
<md>
:information_source: Note: 

For the list of tab indexes to use:
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
<br>

### Student Management
This section describes commands that help you manage your students.

<br>

#### 📝Adding a Student: `add`

You can add a student to F.A.K.E.J.A.R.V.I.S.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL th/TELEGRAM_HANDLE [t/TAG]…​ [gt/GRADED_TESTS]`

| <center>**Parameter**</center>   | <center>**Description**</center>                                         |
|----------------------------------|--------------------------------------------------------------------------|
| <center>NAME</center>            | <center>The name of the student to be added.</center>                    |
| <center>PHONE_NUMBER</center>    | <center>The phone number of the student.</center>                        |
| <center>EMAIL</center>           | <center>The email address of the student.</center>                       |
| <center>TELEGRAM_HANDLE</center> | <center>The Telegram handle of the student.</center>                     |
| <center>TAG</center>             | <center>Tags associated with the student.</center>                       |
| <center>GRADED_TESTS</center>    | <center>Scores of the graded tests associated with the student.</center> |
<br>

<div class="alert alert-info">
<md>
:information_source: Note: 

* You can add any number of tags to a student! (including 0)
* The format for `gt/` is `gt/RA1:0 | RA2:0 | MidTerms:0 | Finals:0 | PE:0`.
* You can use `gt/default` to set graded tests scores as '-' !

</md> </div>

> **Example 1:**
> 
> **Input:** `add n/John Doe p/98765432 e/johnd@u.nus.edu th/johnny01 gt/RA1:0 | RA2:0 | MidTerms:0 | Finals:0 | PE:0` Adds a person called John Doe into F.A.K.E.J.A.R.V.I.S. He has 98765432 as his phone number, johnd@u.nus.edu as his email and johnny01 as his telegram handle. All his grades are also set to `0`. 
> 
> **Output:**
>`New person added: Name: John Doe; Phone: 98765432; Email: johnd@u.nus.edu; Telegram Handle: johnny01; Tags: ; GradedTest: `
> 
> [IMAGE COMING SOON]


> **Example 2:**
>
> **Input:** `add n/Betsy Crowe t/friend e/betsycrowe@u.nus.edu th/itsybetsyspider p/1234567 t/bestie gt/default` Adds a person called Betty Crowe into F.A.K.E.J.A.R.V.I.S. She has 1234567 as her phone number, betsycrowe@u.nus.edu as her email, itsybetsyspider as her telegram handle and bestie as tags. All her grades are also set to `-`.
>
> **Output:**
>`New person added: Name: Betsy Crowe; Phone: 1234567; Email: betsycrowe@u.nus.edu; Telegram Handle: itsybetsyspider; Tags: ; Graded Test: [bestie]; Graded Test: RA1: -; RA2: -; MidTerms: -; Final: -; PE: -`
>
> [IMAGE COMING SOON]


<br>
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
<br>

#### 🛠️Editing a Student Field : `edit`

You can edit an existing student's fields in F.A.K.E.J.A.R.V.I.S.

Format: `edit STUDENT_INDEX [n/NAME] [p/PHONE] [e/EMAIL] [th/TELEGRAM_HANDLE] [t/TAG]…​ [gt/GRADED_TESTS]`

| <center>**Parameter**</center>   | <center>**Description**</center>                                         |
|----------------------------------|--------------------------------------------------------------------------|
| <center>STUDENT_INDEX</center>   | <center>The index of the student to be edited.</center>                  |
| <center>NAME</center>            | <center>The new name for the student.</center>                           |
| <center>PHONE</center>           | <center>The new phone number for the student.</center>                   |
| <center>EMAIL</center>           | <center>The new email address for the student.</center>                  |
| <center>TELEGRAM_HANDLE</center> | <center>The new Telegram handle for the student.</center>                |
| <center>TAG</center>             | <center>New tags associated with the student.</center>                   |
| <center>GRADED_TESTS</center>    | <center>Scores of the graded tests associated with the student.</center> |
<br>

<div class="alert alert-info"><md> :information_source: Note: 

* Edits the person at the specified `STUDENT_INDEX`. 
* The student index refers to the index number shown in the displayed student list. 
* The student index **must be a positive integer** 1, 2, 3, …​
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
<br>

#### 🔎Locating Student by Name: `find`

You can find a student whose name contain any of the given keywords.

Format: `find KEYWORD…`

| <center>**Parameter**</center> | <center>**Description**</center>                 |
|--------------------------------|--------------------------------------------------|
| <center>KEYWORD</center>       | <center>The main keyword to search for.</center> |
<br>


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
<br>

#### ❌Deleting a Student : `delete`

You can delete a specific student from F.A.K.E.J.A.R.V.I.S.

Format: `delete STUDENT_INDEX`

| <center>**Parameter**</center> | <center>**Description**</center>                         |
|--------------------------------|----------------------------------------------------------|
| <center>STUDENT_INDEX</center> | <center>The index of the student to be deleted.</center> |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note: 

* Deletes the person at the specified `STUDENT_INDEX`.
* The student index refers to the index number shown in the displayed student list.
* The student index **must be a positive integer** 1, 2, 3, …​

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
<br>
<br>

### Task Management

This section describes commands that help you manage your tasks.

<br>
<br>

#### 📝Adding a Task: `addtask`

You can add a task to your task list.

Format: `addtask tn/TASK_NAME td/TASK_DESCRIPTION d/DUE_DATE tp/TASK_PRIORITY`

| <center>**Parameter**<center>     | <center>**Description**<center>                                                      |
|-----------------------------------|--------------------------------------------------------------------------------------|
| <center>TASK_NAME</center>        | <center>The name of the task.</center>                                               |
| <center>TASK_DESCRIPTION</center> | <center>The description of the task.</center>                                        |
| <center>DUE_DATE</center>         | <center>The due date or deadline of the task.</center>                               |
| <center>TASK_PRIORITY</center>    | <center>The priority level of the task. Given as `high`, `medium` or `low`.</center> |
<br>

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
<br>

#### 👀Viewing Tasks: `viewtasks`

You can view you list of tasks.

Format: `viewtasks [tn/TASK_NAME] / [td/TASK_DESCRIPTION] / [d/DUE_DATE] / [tp/TASK_PRIORITY] / [tprog/TASK_PROGRESS]`

| <center>**Parameter**</center>    | <center>**Description**</center>                                                              |
|-----------------------------------|-----------------------------------------------------------------------------------------------|
| <center>TASK_NAME</center>        | <center>The name of the task.</center>                                                        |
| <center>TASK_DESCRIPTION</center> | <center>The description of the task.</center>                                                 |
| <center>DUE_DATE</center>         | <center>The due date or deadline of the task.</center>                                        |
| <center>TASK_PRIORITY</center>    | <center>The priority level of the task. Given as `high`, `medium` or `low`.</center>          |
| <center>TASK_PROGRESS</center>    | <center>The progress level of the task. Given as `done`, `pending` or `not_started`.</center> |
<br>

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
<br>

#### 🛠️Updating a Task's Progress: `updateprogress`

You can mark a task as completed.

Format: `updateprogress TASK_INDEX tprog/NEW_PROGRESS`

| <center>**Parameter**</center> | <center>**Description**</center>                                                                   |
|--------------------------------|----------------------------------------------------------------------------------------------------|
| <center>TASK_INDEX</center>    | <center>The index of the task to update the progress.</center>                                     |
| <center>NEW_PROGRESS</center>  | <center>The new progress level of the task. Given as `done`, `pending`, or `not_started`.</center> |
<br>


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The task index refers to the index number shown in the displayed task list.
* The task index **must be a positive integer** 1, 2, 3, …​ that is within the range of the task list.

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
<br>

#### ❌Deleting a Task: `deletetask`

Deletes a task from the task list.

Format: `deletetask TASK_INDEX`

| <center>**Parameter**</center> | <center>**Description**</center>          |
|--------------------------------|-------------------------------------------|
| <center>TASK_INDEX</center>            | <center>The index of the task to delete.</center> |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note:

* The task index refers to the index number shown in the displayed task list.
* The task index **must be a positive integer** 1, 2, 3, …​ that is within the range of the task list.

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
<br>
<br>

### Attendance Management
This section describes commands that help you manage your students' attendance.


<br>
<br>

#### 📆Taking Attendance: `takeattendance`

You can take the attendance of your student(s).

Format: `takeattendance n/STUDENT_NAME s/SESSION_NUMBER ap/PRESENCE`


| <center>**Parameter**</center>  | <center>**Description**</center>                                                       |
|---------------------------------|----------------------------------------------------------------------------------------|
| <center>STUDENT_NAME</center>   | <center>The name of the student.</center>                                              |
| <center>SESSION_NUMBER</center> | <center>The session number of the session.</center>                                    |
| <center>PRESENCE</center>       | <center>The attendance status of the student. Given as `present` or `absent`.</center> |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student must exist in F.A.K.E.J.A.R.V.I.S.

</md>
</div>

> **Example 1:**
>
> **Input:** `takeattendance n/Alex Yeoh s/5 ap/present` Marks Alex Yeoh as present on the 5th session.
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
<br>

#### 👀Viewing Attendance: `viewattendance`

You can view the attendance list of your students.

Format: `viewattendance [n/STUDENT_NAME]…`

| <center>**Parameter**</center> | <center>**Description**</center>                                                |
|--------------------------------|---------------------------------------------------------------------------------|
| <center>STUDENT_NAME</center>  | <center>The name of the student(s) you want to view the attendance of.</center> |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student must exist in F.A.K.E.J.A.R.V.I.S.
* Omitting `n/STUDENT_NAME` will display the overall attendance across all students and sessions. 

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
> **Input:** `s n/Alex Yeoh` Displays all the sessions that Alex Yeoh has attended.
>
> **Output:**
>`2 sessions listed!`
>
> [IMAGE COMING SOON]


> **Example 3:**
>
> **Input:** `viewattendance n/Bernice Yu n/Alex Yeoh` Displays all the sessions that Bernice Yu and Alex Yeoh have attended.
>
> **Output:**
>`2 sessions listed!`
>
> [IMAGE COMING SOON]


[Back to Table of Contents](#table-of-contents)

<br>
<br>
<br>

### Assignment Management
This section describes commands that help you manage your students' assignments.

<br>

#### 👀Viewing a List of Assignments: `viewassignments`

You can view a list of assignment grades and comments.

Format: `viewassignments STUDENT_INDEX`

| <center>**Parameter**</center> | <center>**Description**</center>           |
|--------------------------------|--------------------------------------------|
| <center>STUDENT_INDEX</center> | <center>The index of the student.</center> |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student index refers to the index number shown in the displayed student list.
* The student index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.

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
<br>

#### 🛠️Editing an Assignment Grade: `editgrade`

You can edit your student’s assignment grade.

Format: `editgrade STUDENT_INDEX as/ASSIGNMENT g/GRADE`

| <center>**Parameter**</center> | <center>**Description**</center>             |
|--------------------------------|----------------------------------------------|
| <center>STUDENT_INDEX</center> | <center>The index of the student.</center>   |
| <center>ASSIGNMENT</center>    | <center>The name of the assignment.</center> |
| <center>GRADE</center>         | <center>The score of the student.</center>   |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student index refers to the index number shown in the displayed student list.
* The student index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.
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
<br>

#### ❌Deleting an Assignment Grade: `deletegrade`

You can delete your student’s assignment grade.

Format: `deletegrade STUDENT_INDEX as/ASSIGNMENT`

| <center>**Parameter**</center> | <center>**Description**</center>             |
|--------------------------------|----------------------------------------------|
| <center>STUDENT_INDEX</center> | <center>The index of the student.</center>   |
| <center>ASSIGNMENT</center>    | <center>The name of the assignment.</center> |
<br>

<div class="wrapper">
    <div class="alert alert-info"> 
        <md>
            :information_source: Note:
        </md>
    </div>
    <div class="info">
        <md>
            * The student index refers to the index number shown in the displayed student list.
            * The student index <b>must be a positive integer</b> 1, 2, 3, …​ that is within the range of the student list.
            * The name of the assignment must exist in F.A.K.E.J.A.R.V.I.S.
        </md>
    </div>
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
<br>

#### 🛠️Editing an Assignment Comment: `editcomment`

You can edit the comment of your student’s assignment.

Format: `editcomment STUDENT_INDEX as/ASSIGNMENT c/COMMENT`

| <center>**Parameter**</center> | <center>**Description**</center>             |
|--------------------------------|----------------------------------------------|
| <center>TUDENT_INDEX</center>  | <center>The index of the student.</center>   |
| <center>ASSIGNMENT</center>    | <center>The name of the assignment.</center> |
| <center>COMMENT</center>       | <center>The new comment.</center>            |
<br>


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student index refers to the index number shown in the displayed student list.
* The student index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.
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
<br>

#### ❌Deleting an Assignment Comment: `deletecomment`

You can delete the comment tagged to your student’s assignment.

Format: `deletecomment STUDENT_INDEX as/ASSIGNMENT`

| <center>**Parameter**</center> | <center>**Description**</center>             |
|--------------------------------|----------------------------------------------|
| <center>STUDENT_INDEX</center> | <center>The index of the student.</center>   |
| <center>ASSIGNMENT</center>    | <center>The name of the assignment.</center> |
<br>


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student index refers to the index number shown in the displayed student list.
* The student index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.
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
<br>
<br>

### Graded Test Management
This section describes commands tht help you manage your students' graded tests.

<br>

#### 🛠️Editing a Graded Test Score: `editgradedtest`

You can edit your student’s graded test scores.

Format: `editgradedtest INDEX [ra1/READING_ASSESSMENT_1] [ra2/READING_ASSESSMENT_2] [mt/MIDTERMS] [f/FINALS] 
[pe/PRACTICALEXAM] `

| <center>**Parameter**</center>        | <center>**Description**</center>                                  |
|---------------------------------------|-------------------------------------------------------------------|
| <center>STUDENT_INDEX</center>        | <center>The index of the student.</center>                        |
| <center>READING_ASSESSMENT_1</center> | <center>The score of the student's Reading Assessment 1.</center> |
| <center>READING_ASSESSMENT_2</center> | <center>The score of the student's Reading Assessment 2.</center> |
| <center>MIDTERMS</center>             | <center>The score of the student's MidTerms.</center>             |
| <center>FINALS</center>               | <center>The score of the student's Final Assessment.</center>     |
| <center>PRACTICALEXAM</center>        | <center>The score of the student's Practical Exams.</center>      |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note:

* The student index refers to the index number shown in the displayed student list.
* The student index **must be a positive integer** 1, 2, 3, …​ that is within the range of the student list.
* At least 1 field must be present after the `INDEX`.

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
<br>
<br>

### Session Management
This section describes commands that help you manage your sessions.


<br>

#### 📝Creating a Session: `createsession`

You can create a session for any upcoming or past sessions.

Format: `createsession s/SESSION_NUMBER n/STUDENT_NAME…`

| <center>**Parameter**</center>  | <center>**Description**</center>                    |
|---------------------------------|-----------------------------------------------------|
| <center>SESSION_NUMBER</center> | <center>The session number of the session.</center> |
| <center>STUDENT_NAME</center>   | <center>The name of the student(s).</center>        |
<br>

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
>`New session added: Session: 4; Students: Betsy Crower David Li; Remark: NA`
>
> [IMAGE COMING SOON]


<br>
<br>


#### 🛠️Updating a Session's Remark: `updatesessionremark`

You can update an existing session's remark.

Format: `updatesessionremark s/SESSION_NUMBER r/REMARK`

| <center>**Parameter**</center>  | <center>**Description**</center>                               |
|---------------------------------|----------------------------------------------------------------|
| <center>SESSION_NUMBER</center> | <center>The session number of the session.</center>            |
| <center>REMARK</center>         | <center>The new remark to be updated for the session.</center> |
<br>

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
<br>


#### ❌Deleting a Session: `deletesession`

You can delete an existing session specified by its session number.

Format: `deletesession s/SESSION_NUMBER`

| <center>**Parameter**</center>  | <center>**Description**</center>                    |
|---------------------------------|-----------------------------------------------------|
| <center>SESSION_NUMBER</center> | <center>The session number of the session.</center> |
<br>

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
<br>
<br>

### Consultation Management
This section describes commands that help you manage your consultations with students.


<br>

#### 📝Creating a Consultation: `createconsult`

You can create a consultation for any upcoming consultations.

Format: `createconsult d/DATE tt/TIME n/STUDENT_NAME…`

| <center>**Parameter**</center> | <center>**Description**</center>             |
|--------------------------------|----------------------------------------------|
| <center>DATE</center>          | <center>The date of consultation.</center>   |
| <center>TIME</center>          | <center>The time of consultation.</center>   |
| <center>STUDENT_NAME</center>  | <center>The name of the student(s).</center> |
<br>


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
<br>

#### 📝️Adding students to a consultation: `addtoconsult`
You can add your student(s) into a consultation slot.

Format: `addtoconsult CONSULTATION_INDEX n/STUDENT_NAME…`

| <center>**Parameter**</center>      | <center>**Description**</center>                                              |
|-------------------------------------|-------------------------------------------------------------------------------|
| <center>CONSULTATION_INDEX</center> | <center>The index of the consultation in the upcoming</center> consultations. |
| <center>STUDENT_NAME</center>       | <center>The name of the student to be added to the consultation.</center>     |
<br>


<div class="alert alert-info"> 
<md>

:information_source: Note:

* The consultation index refers to the index number shown in the displayed consultation list.
* The consultation index **must be a positive integer** 1, 2, 3, …​ that is within the range of the consultation list.
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
<br>

#### ❌Removing Students from a Consultation: `removefromconsult`

You can remove your student(s) from a consultation.

Format: `removefromconsult CONSULTATION_INDEX n/STUDENT_NAME…`

| <center>**Parameter**</center>      | <center>**Description**</center>                                              |
|-------------------------------------|-------------------------------------------------------------------------------|
| <center>CONSULTATION_INDEX</center> | <center>The index of the consultation in the upcoming consultations.</center> |
| <center>STUDENT_NAME</center>       | <center>The name of the student to be added to the consultation.</center>     |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note:

* The consultation index refers to the index number shown in the displayed consultation list.
* The consultation index **must be a positive integer** 1, 2, 3, …​ that is within the range of the consultation list.
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
<br>

#### ❌Deleting a Consultation: `deleteconsult`

You can delete the consultation slot specified by an index.

Format: `deleteconsult CONSULTATION_INDEX`

| <center>**Parameter**</center>      | <center>**Description**</center>                                              |
|-------------------------------------|-------------------------------------------------------------------------------|
| <center>CONSULTATION_INDEX</center> | <center>The index of the consultation in the upcoming</center> consultations. |
<br>

<div class="alert alert-info"> 
<md>

:information_source: Note:

* The consultation index refers to the index number shown in the displayed consultation list.
* The consultation index **must be a positive integer** 1, 2, 3, …​ that is within the range of the consultation list.

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

<br>

--------------------------------------------------------------------------------------------------------------------


<br>
<br>

## FAQ

**Q**: How do I transfer my data to another computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous F.A.K.E.J.A.R.V.I.S. home folder.

<br>


--------------------------------------------------------------------------------------------------------------------

<br>

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

<br>

--------------------------------------------------------------------------------------------------------------------

<br>

## Command summary

| <center>**Action**</center>                | <center>**Format**</center>                                                                                                      | <center>**Examples**</center>                                                                                                      |
|--------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| <center>**Add**</center>                   | `add n/NAME p/PHONE_NUMBER e/EMAIL th/TELEGRAM_HANDLE [t/TAG]…​ [gt/GRADED_TESTS]`      <br/>                                    | `add n/James Ho p/12345678 e/jamesho@u.nus.edu th/james03 t/friend t/colleague gt/default`                                         |
| <center>**Clear**</center>                 | `clear`                                                                                                                          | `clear`                                                                                                                            |
| <center>**Delete**</center>                | `delete STUDENT_INDEX`                                                      <br/>                                                | `delete 3`                                                                                                                         |
| <center>**Edit**</center>                  | `edit STUDENT_INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [th/TELGRAM_HANDLE] [t/TAG]…[gt/GRADEDTEST]`                             | `edit 2 n/James Lee e/jameslee@u.nus.edu gt/default`                                                                               |
| <center>**Find**</center>                  | `find KEYWORD [MORE_KEYWORDS]`                                                         <br/>                                     | `find John`<br> `find alex david`                                                                                                  |
| <center>**List**</center>                  | `list`                                                                                                                           | `list`                                                                                                                             |
| <center>**Add Task**</center>              | `addtask tn/TASK_NAME td/TASK_DESCRIPTION d/DUE_DATE tp/TASK_PRIORITY`                                                           | `addtask tn/Prepare Lecture slides d/30/09/2023 tp/high`,<br> `addtask tn/Read Chapter 5`                                          |
| <center>**View Tasks**</center>            | `viewtasks [tn/TASK_NAME] / [td/TASK_DESCRIPTION] / [d/DUE_DATE] / [tp/TASK_PRIORITY] / <br/>[tprog/TASK_PROGRESS]`              | `viewtasks`,<br> `viewtasks tp/high`,<br> `viewtasks d/30/09/2023`                                                                 |
| <center>**Update Progress**</center>       | `updateprogress TASK_INDEX tprog/NEW_PROGRESS`                                                                                   | `updateprogress 1 tprog/pending`,<br>`updateprogress 3 tprog/done`                                                                 |
| <center>**Delete Task**</center>           | `deletetask TASK_INDEX`                                                                                                          | `deletetask 3`,<br>`deletetask 2`                                                                                                  |
| <center>**View Grade**</center>            | `viewgrade STUDENT_INDEX as/ASSIGNMENT`                                                                                          | `viewgrade 1 as/Functional Expressionism`,<br>`viewgrade 2 as/Rune Reading`                                                        |
| <center>**Edit Grade**</center>            | `editgrade STUDENT_INDEX as/ASSIGNMENT g/GRADE`                                                                                  | `editgrade 1 as/Functional Expressionism g/1200`,<br>`editgrade 2 as/Rune Reading g/1000`                                          |
| <center>**Delete Grade**</center>          | `deletegrade STUDENT_INDEX as/ASSIGNMENT`                                                                                        | `deletegrade 1 as/Functional Expressionism`,<br>`deletegrade 2 as/Rune Reading`                                                    |
| <center>**Edit Comment**</center>          | `editcomment STUDENT_INDEX as/ASSIGNMENT c/COMMENT`                                                                              | `editcomment 1 as/Functional Expressionism c/Decent`,<br> `editcomment 2 as/Rune Reading c/Great`                                  |
| <center>**Delete Comment**</center>        | `deletecomment STUDENT_INDEX as/ASSIGNMENT`                                                                                      | `deletecomment 1 as/Functional Expressionism`,<br> `deletecomment 2 as/Rune Reading`                                               |
| <center>**Edit Graded Test**</center>      | `editgradedtest STUDENT_INDEX [ra1/READING_ASSESSMENT_1] [ra2/READING_ASSESSMENT_2] [mt/MIDTERMS] [f/FINALS] [pe/PRACTICALEXAM]` | `editgradedtest 1 ra1/90 ra2/80 mt/85 f/88 pe/95`,<br>`editgradedtest 2 ra1/88 ra2/92 mt/78 f/80 pe/89`                            |
| <center>**Take Attendance**</center>       | `takeattendance n/STUDENT_NAME s/SESSION p/PRESENCE`                                                                             | `takeattendance n/John Doe s/5 present`,<br>`takeattendance n/Foo Bar s/2 absent`                                                  |
| <center>**View Attendance**</center>       | `viewattendance [n/STUDENT_NAME]…`                                                                                               | `viewattendance`,<br>`viewattendance n/Rayan`,<br> `viewattendance n/Jayson Resley`                                                |
| <center>**Create Consultation**</center>   | `createconsult d/DATE tt/TIME n/STUDENT_NAME…`                                                                                   | `createconsult d/30/10/2023 tt/12:30 n/Alex Yeoh`,<br>`createconsult d/30/09/2023 tt/15:30 n/Alex Yeoh n/Betsy Crower n/David Li`  |
| <center>**Add To Consult**</center>        | `addtoconsult CONSULTATION_INDEX n/STUDENT_NAME…`                               <br/>                                            | `addtoconsult 2 n/Betsy Crower`,<br>`addtoconsult 1 n/David Li n/Roy Balakrishnan`                                                 |
| <center>**Remove From Consult**</center>   | `removefromconsult CONSULTATION_INDEX n/STUDENT_NAME…`                                                                           | `removefromconsult 2 n/Betsy Crower`                                                                                               |
| <center>**Delete Consult**</center>        | `deleteconsult CONSULTATION_INDEX`                                                                                               | `deleteconsult 1`                                                                                                                  |
| <center>**Create Session**</center>        | `createsession s/SESSION_NUMBER n/STUDENT_NAME…`                                                                                 | `createsession s/4 n/Betsy Crower n/David Li`                                                                                      |
| <center>**Update Session Remark**</center> | `updatesessionremark s/SESSION_NUMBER r/REMARK`                                                                                  | `updatesessionremark s/2 r/Teach Essence of Recursion`,<br> `updatesessionremark s/4 r/Taught streams and metacircular evalutator` |
| <center>**Delete Session**</center>        | `deletesession s/SESSION_NUMBER`                                                                                                 | `deletesession s/1`,<br>`deletesession s/4`                                                                                        |

<br>
[Back to Table of Contents](#table-of-contents)

<br>

--------------------------------------------------------------------------------------------------------------------

<br>

## Encountering Errors
This section outlines a list of error messages that you may encounter during your usage of the application. It aims to help you better understand the messages that you may receive and what it means to you.

| <center>Error</center>                                                                           | <center>What it means</center>                                                                                                                      | <center>How to resolve</center>                                                                                                                               |
|--------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <center>**Unknown command**</center>                                                             | You have supplied a command that was unrecognisable. <br/> E.g., Command word was given in upper case.                                              | 1. Double-check the spelling and case of the command. <br/> 2. Refer to the [features](#features) section above for the correct commands.                     |
| <center>**Invalid command format!**</center>                                                     | You have supplied a command with the incorrect format. <br/> E.g., Command is missing the compulsory parameters.                                    | 1. Double-check the command format and the parameters required. <br/> 2. Refer to the [features](#features) section above for the correct command formats.    |
| <center>**The Index provided is invalid**</center>                                               | You have provided an index that is out of the range of the items.                                                                                   | 1. Only provide Indexes that are within the range of the list. <br/> E.g., if there are 3 items in the list, the valid indexes that can be used are (1, 2, 3). |
| <center>**At least one field to edit must be provided.**</center>                                | You have not provided a field to edit.                                                                                                              | 1. Double-check that a prefix and a field was provided together with the command.                                                                             |                                   
| <center>**This `task` / `person` already exists in the `task list` / `students list`.**</center> | You have tried to either add a duplicate entry with the same fields, or edit an entry such that all the fields are duplicates of an existing entry. | 1. Double-check that the fields supplied are correct. <br/> 2. Remove the old entry from F.A.K.E.J.A.R.V.I.S.                                                 |
| <center>**Date needs to be in the format dd/MM/yyyy, or date has already crossed.**</center>     | You have either supplied the date in an unrecognisable format, or provided a date that is in the past.                                              | 1. Double-check that the format of the date provided is dd/MM/yyyy (e.g. 28/10/2023) <br /> 2. Choose a date from today or later.                             |
| <center>**Time needs to be in the format HH:mm.**</center>                                       | You have supplied the time in an unrecognisable format.                                                                                             | 1. Double-check that the format of the time provided is HH:mm (e.g. 22:00)                                                                                    |

[Back to Table of Contents](#table-of-contents)
