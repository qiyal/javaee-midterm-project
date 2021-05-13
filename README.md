# Scriptlets

<% (partial) statement %>: book_detail.jsp, cart.jsp, index.jsp, login.jsp, orders.jsp, profile.jsp, registration.jsp

<%-- comment --%>: book_detail.jsp, make_order.jsp

<%! declaration %>: order.jsp

<%= expression %>: book_detail.jsp, cart.jsp, index.jsp, orders.jsp, profile.jsp, 


# Implicit Objects
out: login.jsp, profile.jsp, registration.jsp

request: book_detail.jsp, cart.jsp, login.jsp, orders.jsp, profile.jsp, registration.jsp

session: profile.jsp

#Directives

page: all jsp pages except headejsp and footer. jsp

include: book_detail.jsp, cart.jsp, index.jsp, login.jsp, profile.jsp, registration.jsp

#Action Tags

useBean: book_detail.jsp, cart.jsp, index.jsp, orders.jsp, profile.jsp

include: profile.jsp

param: profile.jsp