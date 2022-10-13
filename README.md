Please open the "MainApplication.java" file in the src folder in intelliJ, then run the program by right-clicking
on the "MainApplication.java" module and clicking run (or pressing Ctrl + Shift + F10).

This will start the program, and you can follow the prompts on the terminal afterwards.

Any data that you add will be automatically saved in the UserDatabase.csv file after you are done with the program,
as long as you exit from the main menu. If you terminate your run, it does not save the data (flight/user/...)

Any Users saved before will be automatically loaded anytime you start the program, so you can log-in using
their username and password. To access the Admin controls, please login with the username "Administrator" and password "admin123."
Please do not delete this account, as only admins are capable of add new admins (can't register as an admin by yourself).

Note on Payment Methods: Card numbers have to be 16 digits long, and pins have to be 3 digits.
While the program will save/load your payment method, it currently will not do anything with it. Loyalty points are also 
saved/loaded, however currently there is no option for exclusive flights. These will be features that will have more 
functionality given a larger scope of the project (time). 

Note that most input prompts are case-sensitive.
Currently the GUI only has the login/register pages, for admin and customers.

Classes are organized based on Clean Architecture.

Contributions (from the design document - the final contributions of each person)
Billy: Graphic UI with login and registeration features, and main page for customer and admin users with other feature pages (developed from text UI version) for future developments. Tests for tickets entity and use cases. Fixed some errors (mainly Ticket ID, time-date representations) for entity class.
Daniel: GenerateFlights, CancelAllFlights, ClearAllUsers. Repackaged Tests into appropriate test folders and wrote tests for nearly all methods in all UseCases. 
Karl:  Implement the Singleton design pattern in the UserTracker. Add methods in the Console class to prompt the users for integer input. Refactor classes related to payments (change to the appropriate data types for storing card numbers and pins). Refactor Presenters and Controllers (user doesn’t need to enter the username repeatedly, add exception handlings, and other minor refactorings).
Mani: Update of UML diagram, design notes on Clean architecture/SOLID, implementation of Payment method (entity + use case + presenter + gateway), Database repackaging, Singleton Design pattern implementation for FlightTracker, User/Customer functionality refactoring
Taymoor: Implemented the Membership features (MembershipMenu, MembershipMenuC, LoyaltyPoints) while refactoring related classes. Adjusted the remaining menus to streamline prompts and test for errors/lack of exit conditions. Design Document extension for Clean Architecture.
