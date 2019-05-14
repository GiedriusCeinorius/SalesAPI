# SalesApi

 Simple REST API that allows managing one resource - Item.

## Prerequisites

1. To run the project, in project directory: mvn spring-boot::run
2. Open "Postman"

## Running tests

Note: There's already added couple Items to begin with.

1. To create an item:

- URI-http://localhost:8082/sales/items
- Request Metthod-POST
- Content-Type-application/json 

```
		{
                "title": "OldShoes",
                "description": "Various ald shoes",
                "price": 12,
                "stock": 152,
                "location": {
                    "country": "Lithuania",
                    "city": "Klaipėda",
                    "gpsCoorinates": [
                        24.8695,
                        24.1236
                    ]
                },
                "comments": [
                    
                ]
			}
```				

2. Update an item:

- URI-http://localhost:8082/sales/items/5cd567afe329ed7ec4b8a43e
- Request Metthod-PUT
- Content-Type-application/json 

```	
{
    "title": "ReebokShoes",
    "description": "New shoes for salee!",
    "price": 55,
    "stock": 6,
    "location": {
        "country": "Lithuania",
        "city": "Radviliskis",
        "gpsCoorinates": [
            25.5665,
            25.3644
        ]
    },
    "comments": [
        "very, good",
        "it has been better",
        "the best"
    ]
}
```	

3. Partialy update an item:

- URI-http://localhost:8082/sales/items/5cd567afe329ed7ec4b8a43e
- Request Metthod-PATCH
- Content-Type-application/json 

```	
{
"description": "Various brand new shoes half the price"
}
```	

4. Get list of items:

- URI-http://localhost:8082/sales/items
- Request Metthod-GET

5. Get a single item by id:

- URI-http://localhost:8082/sales/items/5cd567afe329ed7ec4b8a43e
- Request Metthod-GET

6. Delete an item can authorized user (Basic Auth, username: admin, password: admin):

- URI-http://localhost:8082/sales/items/5cd567afe329ed7ec4b8a43e
- Request Metthod-DELETE
- Basic Auth

7. Search items by title:

- URI-http://localhost:8082/sales/items/search/findItemByTitle?title=AddidasShoes
- Request Metthod-GET

8. Search item by price range:

- URI-http://localhost:8082/sales/items/search/findItemsByPriceBetween?from=40&to=55
- Request Metthod-GET

9. To sort items:

- URI-http://localhost:8082/sales/items?sort=title,desc
- Request Metthod-GET

10. Add comment list for an item:

- URI-http://localhost:8082/sales/items/5cd567afe329ed7ec4b8a43e/addComments
- Request Metthod-POST
- Content-Type-application/json

```	
    [
        "very",
        "ok",
        "the best"
        
    ]
```	
