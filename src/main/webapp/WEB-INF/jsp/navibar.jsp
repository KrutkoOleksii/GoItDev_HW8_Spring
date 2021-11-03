<div class="navbar">
    <a href="${pageContext.request.contextPath}/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Producer
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/producer/producers">Show Producers</a>
            <a href="${pageContext.request.contextPath}/producer/findByName">Find Producer</a>
            <a href="${pageContext.request.contextPath}/producer/add">Create Producer</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Product
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/product/products">Show Products</a>
            <a href="${pageContext.request.contextPath}/product/findByName">Find Product</a>
            <a href="${pageContext.request.contextPath}/product/add">Create Product</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">User
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/user/users">Show Users</a>
            <a href="${pageContext.request.contextPath}/user/findByName">Find User</a>
            <a href="${pageContext.request.contextPath}/user/add">Create User</a>
        </div>
    </div>
</div>