# Bill Split Application

This application will split a given bill and will output the subtotal for each participant.

## Example flow

1. Take a picture of bill or manually input bill entries 
2. Optional: Group entries into orders by:
	* Default: each item is already grouped as one order
	* Sending text messages to each person and ask to select their entries
	* or manually matching each item to person(s)
3. Calculate price for each order
4. Match each order with a participant
5. Optional: send text message to each participant about their order information and total
6. Optional: send Venmo request to each participant

## What we need

1. Splitter class 
 	* Event string i.e. "lunch", "dinner", "birthday"
 	* Bill 
 	* A list of compiled orders
 	* Optional: A map of <participant name, order>
2. Bill class 
	* Arraylist of items
	* Subtotal
	* Total amount in dollars
	* Tax percentage
	* Tip percentage
3. Entry class
4. An order class containing all grouped entries and total price including tip and tax
5. A participant class that will be tied to an order
	* Name
	* Phone number
	* Payment info
	* Order

## Functions needed
1. createEvent()
2. If picture:
	1. uploadBill()
	2. parseBill()
3. addItem()
	1. addItem(String name, double cost)
	2. addItem(String name, double cost, String[] participantNames)
	3. addItem(String name, double cost, Participant[] participants)
4. TBD for now