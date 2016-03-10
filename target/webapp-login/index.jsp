<html>
    <head>
        <title>Login Page</title>
        <style>
            input{
                border: 2px solid #dadada;
                height: 35px;
                width: 100%;
                /*border-radius: 7px;*/ 
            }
            input:focus{
                outline: none;
                border-color: #9ecaed;
                box-shadow: 0 0 10px #9ecaed;
            }
            #title{
                font-weight: 100;
                text-align: center;
                font-size: 1.4em;
            }
            body{       
                background-size: cover;
                font-family: 'Roboto', sans-serif;
                background-color: darkgrey;
                background-image: url(shopping-cart-online.jpg);
                background-size: cover;
            }
            #login{
                padding: 40px;
                width: 374px;
                background-color: #F7F7F7;
                margin: 0 auto 10px;
                border-radius: 2px;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                overflow: hidden;
            }
            #header{
                height: 60px;
                background-color: #111;
                opacity: 0.5;
            }
            div#sep{
                height: 25px;
            }
            .header-text{
                text-align: center;
                font-size: 32px;
                padding-top: 10px;
                color: #fff;
            }
            .buttons{
                border: 0px;
                color: #fff;
                text-shadow: 0 1px rgba(0,0,0,0.1);
                background-color: #4d90fe;
                font-size: 20px;
            }
            input[type=text], input[type=password]{
                height: 44px;
                font-size: 16px;
                width: 100%;
                margin-bottom: 10px;
                background: #fff;
                border: 1px solid #d9d9d9;
                border-top: 1px solid #c0c0c0;
                padding: 0 8px;
                box-sizing: border-box;
            }
            #error{
                color: red;
            }
        </style>
    <body>
        <div id="header">
            <p class="header-text">Welcome to my webapp</p>
        </div>
        <div id="sep">
        </div>
        <div id="login">
            <form name="Login" method="post" action="login">
                <h1 id="title">Enter details to login</h1>
                <table>
                    <input type="text" name="uname" placeholder="Enter user name" required="true"/>
                    <input type="password" name="pass" placeholder="Enter password" required="true"/>
                    <input type="submit" value="Login" class="buttons"/>
                </table>
            </form>
            <div id="error">                
                <%
                    if (request.getAttribute("error_msg") == null) {
                        out.println("");
                    } else {
                        out.println(request.getAttribute("error_msg"));
                    }
                %>
            </div> 
        </div>
    </body>
</html>