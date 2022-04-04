<template>
    <div class="loading-screen">
        <div class="container">
            <div class="vertically-center">
            <h2>Playing</h2>
            <div class="d-flex w-100 justify-content-center">
                <div class="spinner-border" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: "LoadingScreen"
}
</script>

<style scoped>
    .loading-screen{
        top: 0;
        left: 0;
        position: fixed;
        height: 100vh;
        width: 100vw;
        background: rgba(0, 0, 0, 0.5);
        z-index: 100;
    }

    .container{
        height: 100vh;
        position: relative;
    }

    .vertically-center{
        position: absolute;
        top: 40%;
        width: 100%;
    }
</style>