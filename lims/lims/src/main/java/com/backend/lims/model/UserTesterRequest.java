package com.backend.lims.model;

public class UserTesterRequest {
	private User user;
    private Tester tester;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

}
