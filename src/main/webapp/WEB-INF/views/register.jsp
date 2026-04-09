   
   <%@ include file="header.jsp" %>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <div class="container mt-5">

       <div class="row justify-content-center">

           <div class="col-md-4">

               <div class="card shadow p-4">

                   <h3 class="text-center text-success mb-4">Register</h3>

				   <c:if test="${not empty success}">
				       <div class="alert alert-success text-center">
				           ${success}
				       </div>
				   </c:if>
				   
                   <form action="${pageContext.request.contextPath}/register" method="post">

					<input type="text" name="name" placeholder="Name"   class="form-control mb-3" required><br>
					   <input type="text" name="username" placeholder="Username"   class="form-control mb-3" required><br>
					   <input type="email" name="email" placeholder="Email"   class="form-control mb-3" required><br>
					   <input type="password" name="password" placeholder="Password"   class="form-control mb-3" required><br>

                       <button class="btn btn-success w-100">
                           Register
                       </button>

                   </form>

                   <p class="text-danger text-center mt-2">
                       ${error}
                   </p>

               </div>

           </div>

       </div>

   </div>

   <%@ include file="footer.jsp" %>