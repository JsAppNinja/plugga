# Authorization 
## Obtaining tokens
## Making requests with tokens

# Paginated data
  * Endpoints that return more than one entity will be of the following form
  ```
    {
      "links": [
        {
          "rel": "first",
          "href": "http://localhost:5000/api/users?page=0&size=20"
        },
        {
          "rel": "prev",
          "href": "http://localhost:5000/api/users?page=0&size=20"
        },
        {
          "rel": "self",
          "href": "http://localhost:5000/api/users?page=1&size=20"
        },
        {
          "rel": "next",
          "href": "http://localhost:5000/api/users?page=2&size=20"
        },
        {
          "rel": "last",
          "href": "http://localhost:5000/api/users?page=2&size=20"
        }
      ],
      "content": [
      ],
      "page": {
        "size": 20,
        "totalElements": 60,
        "totalPages": 3,
        "number": 0
      }
    }
  ```
  * `prev` and `next` fields will not exist for the first and last pages respectively
  * `href` params `page` and `size` are dependent on the original query
  * `content` field will contain the entries for that page, the format of which is dependent on the entity
    * Each entry in the `content` field will have an extra `links` array in addition to its normal fields
  * Each request made to paginated sources have three optional queries that can be added on to the url
        * `page=0` returns the page number
        * `size=4` returns the size of the `content` field - the number of entities returned per page
        * `sort=name` sorts based on field (the options available for this is therefore different for each entity)
# `/api/cards/`
  * Returned body (will be in an array `[]` if more than one). 
    See section on `/api/sides/` for info on what is in 'sides' field.
    See section on `/api/deck_cards/` for info on what is in 'decks' field.
    
    ```
    {
      "id": 1,
      "lastUsed": "2019-09-06T15:10:39.000+0000",
      "sides": [],
      "decks": []
    }
    ```

### GET
  * All objects `/api/cards/`
  * All by deckId `/api/cards?deckId={deckId}`
  * By cardId `/api/cards/{cardId}`
  
### POST
 * URL `/api/cards/`
 * Request body. All fields are optional.
   * `lastUsed` can be omitted, null, or a timestamp.
   * `sides` can be omitted, an empty array `[]`, or populated with sideIds.
   * `decks` can be omitted, an empty array `[]`, or populated with deckIds.
   * If all three fields are omitted, simply send an empty object `{}`
 ```
{
	"lastUsed": "2019-09-05T22:55:02.000+0000",
	"sides": [1, 3],
	"decks": [2, 7]
}
 ```
 
### PUT
 * URL `/api/cards/{cardId}`
 * Request body. See POST section above and omit `id` field from the body
 
### DELETE
  * URL `/api/cards/{cardId}`
  * Returns `"Deleted card with id: {cardId}"`
  
# `/api/deck_cards/`
  * Returned body (will be in an array `[]` if more than one)
    ```
      {
        "id": 1,
        "deck": 1,
        "card": 1,
        "pile": 1
      }
    ```
### GET
  * All objects `/api/deck_cards/`
  * All by deckId `/api/deck_cards?deckId={deckId}`
  * All by cardId `/api/deck_cards?cardId={cardId}`
  * By deckCardId `/api/deck_cards/{deckCardId}`
### POST
  * URL `/api/deck_cards/`
  * Request body. Each field below represents the respective id's `(deckId, cardId, pileId)`.
  * Pile is optional / nullable and doing so indicates that the card is in a deck but not in a pile (inactive)
  ```
    {
      "deck": 2,
      "card": 7,
      "pile": 1
    }
  ```
### PUT
  * URL `/api/deck_cards/{deckCardId}`
  * Request body. Each field below represents the respective id's `(deckCardId, deckId, cardId, pileId)`
  * Pile is optional / nullable and a null value indicates that the card is in a deck but not in a pile (inactive)
  ```
    {
      "deck": 4,
      "card": 7,
      "pile": 1
    }
  ```
### DELETE
  * URL `/api/deck_cards/{deckCardId}`
  * Returns `"Deleted deckCard with id: {deckCardId}"`
# `/api/decks/`
  * Returned body (will be in an array `[]` if more than one). 
    
    ```
    { 
      "id": 1,
      "name": "Leslie's Deck",
      "imageUrl": "http://plugga.com/somefakeimage.jp",
      "dateCreated": "2019-09-05T22:55:02.000+0000",
    }
    ```

### GET
  * All objects `/api/decks/`
  * All by userId `/api/decks?userId={userId}`
  * By deckId `/api/decks/{deckId}`
  
### POST
  * URL `/api/decks/`
  * Request body. All fields are optional.
    * If all fields are omitted, simply send an empty object `{}`
  ```
  {
    "name": "Deck Name",
    "imageUrl": null
  }
  ```
 
### PUT
 * URL `/api/decks/{deckId}`
 * Request body. Note that 'dateCreated' cannot be updated
  ```
  {
  	"name": "New name",
  	"imageUrl": "updated-url"
  }
  ```
 
### DELETE
  * URL `/api/decks/{deckId}`
  * Returns `"Deleted deck with id: {deckId}"`
  
# `/api/piles/`
* Returned body (will be in an array `[]` if more than one)
  ```
  {
    "id": 1,
    "deck": 1,
    "rank": 1,
    "freqInMinutes": 1
  }
  ```

### GET
  * All objects `/api/piles/`
  * All by deckId `/api/piles?deckId={deckId}`
  * By pileId `/api/piles/{pileId}`

### POST
  * URL `/api/piles/`
  * Request body. 'deck' field represents 'deckId'
  ```
  {
    "deck": 10,
    "rank": 1,
    "freqInMinutes": 7
  }
  ```
### PUT
  * URL `/api/piles/{pileId}`
  * Request body. 'deck' field represents 'deckId'
  ```
  {
    "deck": 10,
    "rank": 4,
    "freqInMinutes": 7
  }
  ```
  
### DELETE
  * URL `/api/piles/{pileId}`
  * Returns `"Deleted pile with id: {pileId}"`
  
# `/api/sides/`
  * Returned body (will be in an array `[]` if more than one)
  ```
  {
    "id": 33,
    "card": 17,
    "imageUrl": "http://plugga.com/static/some_card_image.gif",
    "text": "Who was the second man to walk on the moon?"
  }
  ```

### GET
  * All objects `/api/sides/`
  * All by cardId `/api/sides?cardId={cardId}`
  * By sideId `/api/sides/{sideId}`

### POST
  * URL `/api/sides/`
  * Request body. Each field below represents the respective id's `(cardId)`
  ```
  {
    "card": 7,
  	"imageUrl": "http://plugga.com/static/some_card_image.gif",
  	"text": "side-text-here"
  }
  ```
### PUT
  * URL `/api/sides/{sideId}`
  * Request body. Each field below represents the respective id's `(sideId, cardId)`
  ```
  {
    "card": 7,
    "imageUrl": "updated-url",
    "text": "updated-text"
  }
  ```
  
### DELETE
  * URL `/api/sides/{sideId}`
  * Returns `"Deleted side with id: {sidesId}"`
  
# `/api/user_decks/`
  * Returned body (will be in an array `[]` if more than one)
  ```
    {
      "id": 1,
      "user": {
        "id": 1,
        "name": "Leslie",
        "email": "leslie@plugga.com",
        "dateCreated": "2019-07-12T00:55:46.000+0000",
        "lastLogin": null
      },
      "deck": {
        "id": 1,
        "name": "Leslie's Deck",
        "imageUrl": "http://plugga.com/somefakeimage.jp",
        "dateCreated": "2019-09-05T22:55:02.000+0000"
      }
    }
  ```
### GET
  * All objects `/api/user_decks/`
  * All by deckId `/api/user_decks?deckId={deckId}`
  * All by userId `/api/user_decks?userId={userId}`
  * By userDeckId `/api/user_decks/{userDeckId}`
  
### POST
  * URL `/api/user_decks/`
  * Request body. Each field below represents the respective id's `(userId, deckId)`
  ```
    {
      "user": 1,
      "deck": 7
    }
  ```
### PUT
  * URL `/api/user_decks/{userDeckId}`
  * Request body. Each field below represents the respective id's `(userDeckId, userId, deckId)`
  ```
    {
	  "user": 1,
	  "deck": 7
    }
  ```
### DELETE
  * URL `/api/user_decks/{userDeckId}`
  * Returns `"Deleted userDeck with id: {userDeckId}"`
# `/api/users/`
  * Returned body (will be in an array `[]` if more than one)
  ```
    {
      "id": 1,
      "name": "Leslie",
      "email": "leslie@plugga.com",
      "dateCreated": "2019-07-12T00:55:46.000+0000",
      "lastLogin": null
    }
  ```
### GET
  * All objects `/api/users`
  * By userId `/api/users/{userId}`
  
### POST
  * URL `/api/users/`
  * Request body.
  ```
    {
      "name": "hank",
      "email": "hank.hill@plugga.com",
      "password": "propane"
    }
  ```
### PUT
  * URL `/api/users/{userId}`
  * Request body. Omit any field that is not being updated.
  ```
    {
      "name": "not-hank",
      "email": "hank.hill9@plugga.com",
      "password": "tastethemeatnottheheat"
      "lastLogin": null
    }
  ```
  * dateCreated cannot be updated
### DELETE
  * URL `/api/users/{userId}`
  * Returns `"Deleted user with id: {userId}"`
