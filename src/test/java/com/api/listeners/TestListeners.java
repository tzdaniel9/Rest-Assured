package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListeners.class);
    @Override
    public void onStart(ITestContext context) {
//        ITestListener.super.onStart(context);
        logger.info("Test Suite Started");
    }
    @Override
    public void onTestSuccess(ITestResult result){
//        ITestListener.super.onTestSuccess(result);
        logger.info("Passed " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestStart(ITestResult result){
//        ITestListener.super.onTestSuccess(result);
        logger.info("Started " + result.getMethod().getMethodName());
        logger.info("Description " + result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        ITestListener.super.onTestFailure(result);
        logger.error("Failed " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
        logger.info("Skipped " + result.getMethod().getMethodName());

    }

    @Override
    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
        logger.info("Test Suite Finished");

    }
}
