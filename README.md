# DynamicSpringBootSecurity
sample project for dynamically loading urls to permit spring security from database.

Steps:-

On first boot it will by default initiate only one url to bypass from security i.e. "/token/*"

swagger link :- http://localhost:8080/swagger-ui.html#/

there are total 4 apis:-

1) authentication controller (open from security as above mentioned by /token/*)
  a) signup (for creating user)
  b) generate token (for login and creating token used to authenticate)

2) post controller (secured)
  a) to create post
  b) to get api
  
now to bypass any url from security just add it to the db, like the for example if you want to bypass create post api then enter the url i.e. /post/create
