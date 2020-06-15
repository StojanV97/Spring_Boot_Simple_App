import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Service from '@/components/Service'
import Bootstrap from '@/components/Bootstrap'
import User from '@/components/User'
import Login from '@/components/Login'
import Protected from '@/components/Protected'
import Test from '@/components/Test'
import store from './store'
import AddPainter from "./components/AddPainter";
import PreviewPainter from "./components/PreviewPainter";
import EditPainter from "./components/EditPainter";
import AddArt from "./components/AddArt";
import PreviewArt from "./components/PreviewArt";
import EditArt from "./components/EditArt";
import TableView from "./components/TableView"
import Tutorial from "./components/Tutorial"

Vue.use(Router);

const router = new Router({
    mode: 'history', // uris without hashes #, see https://router.vuejs.org/guide/essentials/history-mode.html#html5-history-mode
    routes: [
        { path: '/', component: Test },
        { path: '/preview', component: PreviewPainter },
        { path: '/previewart', component: PreviewArt },
        { path: '/addart', component: AddArt },
        { path: '/edit', component: EditPainter },
        { path: '/editart', component: EditArt },
        { path: '/callservice', component: Service },
        { path: '/bootstrap', component: Bootstrap },
        { path: '/user', component: User },
        { path: '/login', component: Login },
        { path: '/home-page', component: Test },
        { path: '/table-view', component: TableView },
        { path: '/e', component: EditPainter },
        { path: '/tutorial', component: Tutorial },
        {
            path: '/protected',
            component: Protected,
            meta: {
                requiresAuth: true
            }
        },

        // otherwise redirect to home
        { path: '*', redirect: '/' }
    ]
});

router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        // this route requires auth, check if logged in
        // if not, redirect to login page.
        if (!store.getters.isLoggedIn) {
            next({
                path: '/login'
            })
        } else {
            next();
        }
    } else {
        next(); // make sure to always call next()!
    }
});

export default router;