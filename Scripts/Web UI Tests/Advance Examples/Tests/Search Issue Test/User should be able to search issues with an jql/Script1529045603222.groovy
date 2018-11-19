import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/**
 * The test case verifies that Jira tickets can be search by jql.
 * 
 * Given The Jira system is available
 * When I login the system with default account
 * and I open the Search for issue page
 * and I perform a search using issue's summary
 *
 * @params
 * issue_summary: issue's summary
 */

WebUI.callTestCase(findTestCase('Web UI Tests/AUT_Jira/Page Objects/Login Page/login(username, encrypted_password)'), [('username') : GlobalVariable.username
        , ('encryptedPassword') : GlobalVariable.encrypted_password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Web UI Tests/AUT_Jira/Page Objects/Master Page/openSearchPage'), [:], FailureHandling.STOP_ON_FAILURE)

jql = String.format('text~"%s"', issue_summary)

WebUI.callTestCase(findTestCase('Web UI Tests/AUT_Jira/Page Objects/Search Issue Page/searchByJql(jql)'), [('jql') : jql], FailureHandling.STOP_ON_FAILURE)

