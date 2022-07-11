package Entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserTracker {
    /**
     * A HashMap that maps usernames to User objects for all users in the system.
     */
    private static Map<String, User> allUsers = new HashMap<String, User>(); // HashMap for constant lookup time.
    /**
     * A User object indicate the user currently being tracked.
     */
    private User currentUser;

    /**
     * Construct a new UserTracker with the username of the User that will be tracked.
     *
     * @param  username The username of the User to track.
     */
    public UserTracker (String username) {
        this.currentUser = allUsers.get(username);
    }

    /**
     * Add a new User to the list of all users.
     *
     * @param  newUser The new User to add.
     */
    public static void addUser (User newUser) {
        allUsers.put(newUser.getUsername(), newUser);
    }

    /**
     * Add a new User to the list of all users.
     *
     * @return Return an int represent the total number of users in the system.
     */
    public static int getTotalUserCount () {
        return allUsers.size();
    }

    /**
     * Get a shallow copy of the HashMap of all users.
     * <p>
     * Try to avoid using this method if you want to track only one User. It is very inefficient and is created solely
     * for saving the allUsers map.
     *
     * @return Return a shallow copy of the HashMap of all users.
     */
    public static Map<String, User> getAllUsers() {
        return new HashMap<String, User>(allUsers);
    }

    /**
     * Get the User object of the user currently being tracked.
     *
     * @return Return the User object of the user currently being tracked.
     */
    public User getCurrentUser () {
        return this.currentUser;
    }

    /**
     * Track another User with the username passed in as a String.
     *
     * @param username The username of the new User to track.
     */
    public void changeCurrentUser(String username) {
        this.currentUser = allUsers.get(username);
    }

    /**
     * Check if the User currently being tracked is in the system or not.
     *
     * @return Return a boolean indicate whether the User exists in the system.
     */
    public boolean userExists () {
        return this.currentUser != null;
    }

    /**
     * Remove the currently tracked User from the system.
     */
    public void removeCurrentUser () {
        if (this.userExists()) {
            allUsers.remove(this.currentUser.getUsername());
            this.currentUser = null;
        }
    }
}