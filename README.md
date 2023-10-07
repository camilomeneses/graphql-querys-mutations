## Graphql querys and mutations to graphiql práctica
## Acceso
```bash
http://localhost:8080/graphiql?path=/graphql
```

### Obtener todos los libros
```graphql
query FindAllBooks {
  findAllBooks {
    id
    title
    pages
    author
    reviews {
      id
      title
      comment
    }
  }
}
```
#### Resultado Esperado (Similar)
```json
{
  "data": {
    "findAllBooks": [
      {
        "id": "1",
        "title": "Spring in Action",
        "pages": 500,
        "author": "Ben Haskell",
        "reviews": [
          {
            "id": "1",
            "title": "Great book!",
            "comment": "I loved it a lot"
          }
        ]
      }
    ]
  }
}
```
### Crear Nuevo Libro
```graphql

mutation CreateBook {
  createBook(title: "My New Book", pages: 99, author: "Camilo") {
    id
    title
    pages
    author
  }
}
```
#### Resultado Esperado
```json
{
  "data": {
    "createBook": {
      "id": "5",
      "title": "My New Book",
      "pages": 99,
      "author": "Camilo"
    }
  }
}
```
### Agregar Input de Clase Book
```graphql

mutation AddBook {
  addBook(book:{title: "My New Book Input", pages: 199, author: "Camilo"}){
    id
    title
    pages
    author
  }
}
```
### Resultado Esperado
```json
{
  "data": {
    "addBook": {
      "id": "6",
      "title": "My New Book Input",
      "pages": 199,
      "author": "Camilo"
    }
  }
}
```
### Batch de Creacion de Multiples Inputs de Book
 ```graphql
mutation BatchCreateBooks{
    batchCreateBooks(books: [
        {title: "Batch Book 1", pages: 10, author:"Author 1"},
        {title: "Batch Book 2", pages: 10, author:"Author 2"},
        {title: "Batch Book 3", pages: 10, author:"Author 3"},
        {title: "Batch Book 4", pages: 10, author:"Author 4"},
        {title: "Batch Book 5", pages: 10, author:"Author 5"},
    ]){
        id
        title
        pages
        author
    }
}
 ```
### Resultado esperado
```json
{
  "data": {
    "batchCreateBooks": [
      {
        "id": "2",
        "title": "Batch Book 1",
        "pages": 10,
        "author": "Author 1"
      },
      {
        "id": "3",
        "title": "Batch Book 2",
        "pages": 10,
        "author": "Author 2"
      },
      {
        "id": "4",
        "title": "Batch Book 3",
        "pages": 10,
        "author": "Author 3"
      },
      {
        "id": "5",
        "title": "Batch Book 4",
        "pages": 10,
        "author": "Author 4"
      },
      {
        "id": "6",
        "title": "Batch Book 5",
        "pages": 10,
        "author": "Author 5"
      }
    ]
  }
}
```
More information on DanVega's Youtube Channel