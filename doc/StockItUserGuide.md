# *StockIt* User Guide


## What is *StockIt*?

*StockIt* is a text based user interface via command line to maintain a Grocery List.
* Allow user to create a Grocery List by adding new Items.
* Assign them Quantity, Status and PurchaseByDate.
* Choose a Category they might belong to.
* Modify an Item on the list.
* Remove the Item from the list.
* Show the Grocery List filtered by current date and sorted by status.
* Show the Grocery List filtered on status and sorted on Date.
* Save the current Grocery List to File.
* Restores the Grocery List when application restarts
* Item Status identifies priority of an Item.
	 * Running Low indicates that Item quantity is low 
	 * Need to Buy indicates that Item is finished and need to be brought 
	 * Brought indicates that Item is already brought	 
* Item Category for Classification of Items.
 	* Edible when an Item can be consumed
 	* Inedible when an Item cant not be consumed	 
	
------------
## Installing Software

- Step 1: Download "StockIt.zip" and extract the files, example on Windows C Drive.

![Download](https://github.com/GazalaS/StockIt/blob/master/doc/img/zipsave.PNG)

- Step 2: Open command prompt and traverse to extraction directory, example C:/StockIt/StockIt .

![Extract](https://github.com/GazalaS/StockIt/blob/master/doc/img/extractfiles.PNG)

- Step 3: Execute the jar with command 
			java -jar "sda3.ip.stockit.jar"

			
![ExecuteApp](https://github.com/GazalaS/StockIt/blob/master/doc/img/executeapp.PNG)	

------------
## Using *StockIt*

- When application is executed for first time. Welcome Menu displays count as zero of "Items to Buy" and "Items Running Low"

![WelcomeMenu](https://github.com/GazalaS/StockIt/blob/master/doc/img/welcomemenu.PNG)

- When application is reloaded. Welcome Menu shows count of "Items to Buy" and "Items Running Low", if any followed by Menu Options as described below.

![WelcomeMenuDisplayCount](https://github.com/GazalaS/StockIt/blob/master/doc/img/welcomemenudisplaycount.png)

------------
### <Option 1> Show Grocery List by Status
------------
- Choose option 1 on Menu screen.
- If Grocery List is empty, you will be asked to add Items.

![Option1EmptyList](https://github.com/GazalaS/StockIt/blob/master/doc/img/op1emptylist.PNG)

- If there are items in Grocery List, you will be able to see items filtered into 3 status and sorted by date.
	- Items Running Low
	- Items Need to Buy
	- Items Brought

![Option1ItemsinList](https://github.com/GazalaS/StockIt/blob/master/doc/img/op1availableitems.PNG)

------------
### <Option 2> Add a Grocery Item
------------

- Choose option 2 on Menu screen to Add.
- Please enter Item Name, Item Quantity, To be purchased by Date, Item Category & Item Status.
	- Item Name should be Alphabetic only
	- Item Quantity can be Numeric or Alpha numeric, eg both 2 and/or 2 kgs are valid
	- To be purchased by Date should be current or future date and should be in format 'dd-mm-yyyy'
	- Item Category can be 1.Edible or 2.Inedible. Please mention either 1 or 2
	- Item Status can be 1.Running Low or 2.Need to Buy. Please mention either 1 or 2
- Upon adding right details about your item, it will be added in *StockIt* Grocery List.

![Option2AddItem](https://github.com/GazalaS/StockIt/blob/master/doc/img/op2additem.PNG)

------------
### <Option 3> Edit a Grocery Item
------------

- Choose option 3 on Menu screen.
- It will show you the items that have been added/edited in current or previous application sessions.
- If there are no items to Edit, it will ask to Add an Item first.

![Option3EditItemEmptyList](https://github.com/GazalaS/StockIt/blob/master/doc/img/op3edititememptylist.PNG)

- Please select an item number to Edit.
- Please enter Item Name, Item Quantity, To be purchased by Date, Item Category & Item Status.
	- Item Name should be Alphabetic only
	- Item Quantity can be Numeric or Alpha numeric, eg both 2 and/or 2 kgs are valid
	- To be purchased by Date should be current or future date and should be in format 'dd-mm-yyyy'
	- Item Category can be 1.Edible or 2.Inedible. Please mention either 1 or 2
	- Item Status can be 1.Running Low or 2.Need to Buy or 3. Brought. Please mention either 1 or 2 or 3
- Upon adding right details about your item, it will be updated in *StockIt* Grocery List.

![Option3EditItem](https://github.com/GazalaS/StockIt/blob/master/doc/img/op3edititem.PNG)

------------
### <Option 4> Remove a Grocery Item
------------

- Choose option 4 on Menu screen.
- If there are no items to Remove, it will ask to Add an Item first.

![Option4RemoveItemEmptyList](https://github.com/GazalaS/StockIt/blob/master/doc/img/op4removeitememptylist.PNG)

- It will show you the items that have been added/edited in current or previous application sessions.
- Please select an item number to remove.
- It will remove selected item from *StockIt* Grocery List.


![Option4RemoveItem](https://github.com/GazalaS/StockIt/blob/master/doc/img/op4removeitem.PNG)

------------
### <Option 5> Show Grocery List for Today
------------

- Choose option 5 on Menu screen.
- If there are no items for Today, it will ask to Add an Items.

![Option5ShowbyDate](https://github.com/GazalaS/StockIt/blob/master/doc/img/op5showbydateemptylist.png)

- It will show you the items that have been added/edited in current or previous application sessions for today's date.

![Option5ShowbyDate](https://github.com/GazalaS/StockIt/blob/master/doc/img/op5showbydate.PNG)

------------
### <Option 6> Save and Quit
------------

- Choose option 6 on Menu screen.
- It will save the final list of items in a File.

![Option6SavenQuit](https://github.com/GazalaS/StockIt/blob/master/doc/img/file.png)

- It will exit current session with greeting message.

![Option6SavenQuit](https://github.com/GazalaS/StockIt/blob/master/doc/img/op6savenquit.PNG)
