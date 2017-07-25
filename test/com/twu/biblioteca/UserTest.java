package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user1;

    @Before
    public void setUp() {
        user1 = new User("userName1", "user1@user1.com", "18888888888", "111-1111", "111");
    }

    @Test
    public void shouldReturnUserDetail() {
        assertEquals("userName1", user1.getName());
        assertEquals("user1@user1.com", user1.getEmail());
        assertEquals("18888888888", user1.getPhoneNumber());
        assertEquals("name:userName1 email:user1@user1.com phoneNumber:18888888888", user1.getUserDetail());
    }

    @Test
    public void shouldReturnTrueWhenHaveCorrectPassInformation() {
        assertTrue(user1.checkCredentials("111-1111", "111"));
    }

    @Test
    public void shouldReturnFalseWhenHaveIncorrectPassInformation() {
        assertFalse(user1.checkCredentials("111-1111", "222"));
    }
}
