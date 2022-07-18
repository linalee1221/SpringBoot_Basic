<template>
  <div id="page-top">
    <!-- Navigation-->
    <!-- m(margin), l(left), r(right), t(top), b(bottom) - 1~5 -->
    <!-- <a class="menu-toggle rounded mt-5" href="#"><i class="fas fa-bars"></i></a>
    <nav id="sidebar-wrapper">
      <ul class="sidebar-nav">
        <li class="sidebar-brand"><a href="#page-top">Start Bootstrap</a></li>
        <li class="sidebar-nav-item"><a href="#page-top">Home</a></li>
        <li class="sidebar-nav-item"><a href="#about">About</a></li>
        <li class="sidebar-nav-item"><a href="#services">Services</a></li>
        <li class="sidebar-nav-item"><a href="#portfolio">Portfolio</a></li>
        <li class="sidebar-nav-item"><a href="#contact">Contact</a></li>
      </ul>
    </nav> -->
    <!-- Header -->
    <HeaderCom></HeaderCom>
    <!-- Section -->
    <SectionCom></SectionCom>
    <!-- Footer -->
    <FooterCom></FooterCom>
  </div>
</template>

<script>
// Todo : bootstrap 테마 js 적용
import loadWin from "@/assets/js/scripts"
import HeaderCom from "@/components/home/HeaderCom";
import SectionCom from "@/components/home/SectionCom";
import FooterCom from "@/components/home/FooterCom";


export default {
  name: 'HomeView',
  components: {
    HeaderCom,
    SectionCom,
    FooterCom
  },
  // 화면이 뜨자마자 실행되는 이벤트
  mounted() {
    loadWin();
  }
}
</script>

<style>
/* Todo : bootstrap 테마 사용자 css import */
@import '../assets/css/styles.css';
</style>
