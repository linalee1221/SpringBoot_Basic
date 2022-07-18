<template>
  <!-- <div id="app"> -->
    <!-- <nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand mr-4" href="#">
        <img src="@/assets/img/1762755.png" width="30" height="30" alt=""></a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav"> -->
          <!-- 첫번째 드롭다운 시작 -->
          <!-- <li class="nav-item dropdown mr-4">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdownMenuLink"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              About
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <router-link to="/home" class="dropdown-item">
                Home
              </router-link>
              <router-link to="/complain" class="dropdown-item"> 
                Complain 
              </router-link>
            </div>
          </li> -->
          <!-- 첫번째 드롭다운 끝 -->

          <!-- 두번째 드롭다운 시작 -->
          <!-- <li class="nav-item dropdown mr-4">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdownMenuLink"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              Tutorial
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <router-link to="/tutorials" class="dropdown-item">
                Tutorials
              </router-link>
              <router-link to="/add" class="dropdown-item"> Add </router-link>
              <router-link to="/upload" class="dropdown-item"> Upload Image </router-link>
            </div>
          </li> -->
          <!-- 두번째 드롭다운 끝 -->

          <!-- 세번째 드롭다운 시작 -->
          <!-- <li class="nav-item dropdown mr-4">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdownMenuLink"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              Customers Menu
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <router-link to="/customers" class="dropdown-item">
                Total Customer List
              </router-link>
              <router-link to="/add-customer" class="dropdown-item"> Add New Customer </router-link>
            </div>
          </li> -->
          <!-- 세번째 드롭다운 끝 -->
        <!-- </ul>
      </div>
    </nav>

    <div class="container mt-3"> -->
      <!-- 위의 router-link 있는 메뉴 화면이 아래위치에 표시 -->
      <router-view></router-view>
    <!-- </div>
  </div> -->
</template>

<script>
export default {
  name: "app",
};
</script>

<style></style>
