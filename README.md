# inventions-api
Spring boot application : REST API with basic CRUD

Host : 34.244.25.62 \
Port : 8080

example of call : 
> curl -XGET 34.244.25.62:8080/inventions

Endpoints : 

- GET /inventions
- GET /inventions/:id
- POST /inventions \
  Request body :
  ```javascript
  {
        "date": 1862,
        "name": "Les Misérables",
        "inventor": "Victor Hugo",
        "origine": null,
        "site": null,
        "tags": [
            "Papier",
            "Livre",
            "Ecriture",
            "Histoire",
            "Auteur"
        ]
  }
  ``` 
  Please note that only the name attribute is mandatory
  - DELETE /inventions/:id
  - PUT /inventions/init \
  Request body : 
    ```javascript
    [
    {
      "id": 12,
      "date": 1837,
      "name": "L'invention du télégraphe",
      "inventor": "Samuel Finley Breese Morse",
      "origine": null,
      "site": "https://fr.wikipedia.org/wiki/T%C3%A9l%C3%A9graphe",
      "tags": [
         "Electrique",
         "Courant",
         "Communication"
      ]
    },
    {
      "id": 3,
      "date": 1862,
      "name": "Les Misérables",
      "inventor": "Victor Hugo",
      "origine": null,
      "site": null,
      "tags": [
         "Papier",
         "Livre",
         "Ecriture",
         "Histoire",
         "Auteur"
      ]
     }
    ]
   ``` 
  - GET /inventions/tag/:tag
  - GET /inventions/:id/discovery
