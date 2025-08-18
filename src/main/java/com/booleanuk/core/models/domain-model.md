| **Classes** | **Methods**                               | **Scenario**                                               | **Outputs**                                    |
|-------------|-------------------------------------------|------------------------------------------------------------|------------------------------------------------|
| `Basket`    | `addBagel(Bagel bagel)`                   | If user adds a bagel to an empty basket                    | Adds the bagel to the basket                   |
|             |                                           | If user adds a bagel and basket is full                    | Error message: "Basket is full."               |
|             | `removeBagel(Bagel bagel)`                | If user tries to remove a bagel in the basket              | Removes the bagel from the basket              |
|             |                                           | If user tries to remove a bagel not in the basket          | Error message: "Item not in basket."           |
|             | `getTotalCost()`                          | When the user checks the total cost of the basket          | Returns total price of all items in the basket |
| `Bagel`     | `getPrice()`                              | If user checks the price of a specific bagel               | Returns price of the bagel                     |
|             | `chooseFillings(List<Filling> fillings)`  | If user selects fillings for a bagel                       | Updates the bagel with selected fillings       |
|             | `getFillingCost(List<Filling> fillings)`  | If user checks the cost of fillings                        | Returns total cost of selected fillings        |
| `Manager`   | `changeBasketCapacity(int capacity)`      | If manager decides to change basket capacity               | Updates basket capacity                        |
|             | `addToInventory(Bagel bagel)`             | If manager adds new item to inventory not in inventory     | Updates inventory                              |
|             |                                           | If manager adds new item which is in inventory             | Returns error: "Item already exists."          |
| `Customer`  | `addBagelToBasket(String stu)`            | If customer adds a bagel to their basket                   | Adds the bagel to the basket                   |
|             |                                           | If the bagel is out of stock                               | Returns error: "Bagel out of stock."           |
|             |                                           | If the bagel is out of stock                               | Returns error: "Bagel out of stock."           |
|             | `removeBagelFromBasket(String stu)`       | If customer removes a bagel from their basket              | Removes the bagel from the basket              |
|             |                                           | If the bagel is not in the basket                          | Returns error: "Bagel not in basket."          |
|             | `viewTotalCost()`                         | If customer checks the total cost of items in their basket | Returns total cost of all items in the basket  |
|             | `viewBagelPrice(Bagel bagel)`             | If customer checks the price of a specific bagel           | Returns price of the selected bagel            |
|             | `selectFillings(int option)`              | If customer selects fillings for a bagel                   | Updates the bagel with selected fillings       |
|             | `viewFillingCost(List<Filling> fillings)` | If customer checks the cost of selected fillings           | Returns total cost of selected fillings        |
|             | `orderBagelAtSpecificTime`                | If customer wants to order bagel before set time           |                                                |
| `Inventory` | `addItem`                                 | If manager wants to add new item to inventory              | Update inventory                               |
|             | `removeItem`                              | If manager wants to remove item from inventory             | Remove item from inventory                     |
| `Filling`    | ``                                        |      |                |