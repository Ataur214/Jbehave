
					 
Scenario:  A scenario is a collection of executable steps of different type
Given I open a browser
When I enter the  https://nbttest.yr.com
And select the User ID checkbox
And ender the <username> and <password>
And select the ap from dropdown
And click on the login button
Then nbttest page title is displayed

Examples:				 
|username|password|
|master.swp|DSBS@2o19|
