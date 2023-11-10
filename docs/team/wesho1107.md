---
layout: default.md
title: "Ho Jia Cheng's Project Portfolio Page"
---
### Project: F.A.K.E.J.A.R.V.I.S.

F.A.K.E.J.A.R.V.I.S. is a project to help CS1101S Avengers manage their time and responsibilities more effectively.

Below are my contributions to the project:

* **New Features**: Added the features for creating, deleting and editing consultations.
  * What it does: Allows Avengers to create, delete, or edit consultations, allowing for easy tracking of discussions outside of lesson time.
  * Justification: With the heavy pile of responsibilities an Avenger has to keep track of, scheduled consultations may be easily forgotten, thus this feature helps in tracking the date, time and students attending a consultation.
  * Highlights: There were some design thought given to how information is stored in the model. To prevent cyclic-reference between students and consultations, we decided on a uni-directional relationship, where only consultations store student models, and not consultations in students.
  * Credits: No reuse of code or third-party libraries.


* **New Features**: Added the feature for switching tabs between different lists.
  * What it does: Allows Avengers to switch between tabs of different lists (Students, Tasks, Assignments, Sessions, Consultations).
  * Justification: With multiple features in our one-stop platform, it may be visually overbearing for an Avenger to see all feature lists at once, thus this feature helps to keep information organised and neat.
  * Highlights: There were some user experience thought given to how the tabs works. To achieve a fast Command-Line Interface centred application, commands are written for the ease of switching between tabs.
  * Credits: No reuse of code or third-party libraries.


* **New Features**: Improved the user interface of the F.A.K.E.J.A.R.V.I.S.
  * What is changed: The color, layout and organisation of information of the application.
  * Justification: With multiple features in our one-stop platform, a user interface update was required to organise information displayed neatly.
  * Highlights: There were some user experience thought given to the improved user interface. A Graphical Result Display is implemented to display details relevant to commands that were called.
  * Credits: No reuse of code or third-party libraries.


* **Code contributed**: [RepoSense](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=wesho1107&breakdown=true)


* **Project management**:
  * Organised Git issues.
  * Reviewed and approved pull requests.


* **Enhancements to existing features**:
  * Changed the user interface for the overall application for better user experience.
  * Updated commands to switch between corresponding tabs when invoked by user.


* **Documentation**:
  * User Guide:
    * Added documentation for the Consultation Management Session
    * Redesigned annotated images for better representation of the UI of the product.

  * Developer Guide: To be added
    * Designed the class diagram for `Consultation`.


* **Review/mentoring contributions**: To be added

* **Tools**: Java, IntelliJ, FXML, PlantUML

* **Contributions beyond the project team**: To be added

