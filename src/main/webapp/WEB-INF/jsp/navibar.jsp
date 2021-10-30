<div class="navbar">
    <a href="${pageContext.request.contextPath}/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Company
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/producer/">Show Producers</a>
            <a href="${pageContext.request.contextPath}/producer/findProducer">Find Producer</a>
            <a href="${pageContext.request.contextPath}/producer/addProducer">Create Producer</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Customer
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/product/">Show Products</a>
            <a href="${pageContext.request.contextPath}/product/findProduct">Find Product</a>
            <a href="${pageContext.request.contextPath}/product/addProduct">Create Product</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Developer
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/user/">Show Users</a>
            <a href="${pageContext.request.contextPath}/user/findUser">Find User</a>
            <a href="${pageContext.request.contextPath}/user/addUser">Create User</a>
        </div>
    </div>
</div>