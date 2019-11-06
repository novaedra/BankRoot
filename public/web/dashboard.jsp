<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%
    String nom = (String) request.getAttribute("nom");
    String prenom = (String) request.getAttribute("prenom");
    String ident = (String) request.getAttribute("ident");
    String mail = (String) request.getAttribute("mail");
    String telephone = (String) request.getAttribute("telephone");
    String birthday = (String) request.getAttribute("birthday");
    String adresse = (String) request.getAttribute("adresse");
    String password = (String) request.getAttribute("password");
    String age = (String) request.getAttribute("age");
%>

<div class="dropdown">
    <button onclick="showClientList()" class="dropbtn"><img id="menuDeroulant" alt="icône menu déroulant"
                                                            src="assets/img/menu_dropdown.svg"/></button>
    <div id="dropdown-content" style="display: none;">
        <a class="btnClient" onclick="showClientDetail('client1')">wwwwwwwwwwwwwwwwwww Léo</a>
        <a class="btnClient" onclick="showClientDetail('client2')">Client 2</a>
        <a class="btnClient" onclick="showClientDetail('client3')">Client 3</a>
        <a class="btnClient" onclick="showClientDetail('client4')">Client 4</a>
        <a class="btnClient" onclick="showClientDetail('client5')">Client 5</a>
        <a class="btnClient" onclick="showClientDetail('client6')">Client 6</a>
        <a class="btnClient" onclick="showClientDetail('client7')">Client 7</a>
        <a class="btnClient" onclick="showClientDetail('client8')">Client 8</a>
        <a class="btnClient" onclick="showClientDetail('client9')">Client 9</a>
        <a class="btnClient" onclick="showClientDetail('client10')">Client 10</a>
        <a class="btnClient" onclick="showClientDetail('client11')">Client 11</a>
        <a class="btnClient" onclick="showClientDetail('client12')">Client 12</a>
        <a class="btnClient" onclick="showClientDetail('client13')">Client 13</a>
        <a class="btnClient" onclick="showClientDetail('client14')">Client 14</a>
        <a class="btnClient" onclick="showClientDetail('client15')">Client 15</a>
        <a class="btnClient" onclick="showClientDetail('client10')">Client 16</a>
        <a class="btnClient" onclick="showClientDetail('client11')">Client 17</a>
        <a class="btnClient" onclick="showClientDetail('client12')">Client 18</a>
        <a class="btnClient" onclick="showClientDetail('client13')">Client 19</a>
        <a class="btnClient" onclick="showClientDetail('client14')">Client 20</a>
    </div>
</div>

<div id="client1" class="liste">
    <ul>
        <li>Nom : <%= nom %>
        </li>
        <li>Prénom : <%= prenom %>
        </li>
        <li>Mail : <%= mail %>
        </li>
        <li>Téléphone : <%= telephone %>
        </li>
        <li>Adresse : <%= adresse %>
        </li>
        <li>Date de naissance / age: <%= birthday %> / <%= age %>
        </li>
    </ul>
    <button onclick="closeClientDetail('client1')">Fermer</button>
</div>

<div id="client2" class="liste">
    <ul>
        <li>Nom : <%= nom %>
        </li>
        <li>Prénom : <%= prenom %>
        </li>
        <li>Mail : <%= mail %>
        </li>
        <li>Téléphone : <%= telephone %>
        </li>
        <li>Adresse : <%= adresse %>
        </li>
        <li>Date de naissance / age: <%= birthday %> / <%= age %>
        </li>
    </ul>
    <button onclick="closeClientDetail('client2')">Fermer</button>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<%@include file="includes/footer.jsp" %>
