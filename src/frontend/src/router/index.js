import {createRouter, createWebHistory} from 'vue-router'
import GameDetails from '../views/GameDetails'
import HomeView from '../views/HomeView'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: HomeView
    },
    {
        path: '/details/:gameId',
        name: 'GameDetails',
        component: GameDetails,   
        props: true     
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router