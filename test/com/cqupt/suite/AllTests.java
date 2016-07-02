package com.cqupt.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cqupt.service.UserServiceTest;

@RunWith(Suite.class)
@SuiteClasses({UserServiceTest.class})
public class AllTests {

}
