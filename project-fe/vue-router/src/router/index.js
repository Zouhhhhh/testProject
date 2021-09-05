import Vue from 'vue';
import VueRouter from 'vue-router';
import Index from '../components/index.vue';
import Books from '../components/books.vue';
import News from '../components/news.vue';
Vue.use(VueRouter);

const routes = [{
    path: '/',
    component: Index,
},
{
    path: '/books',
    component: Books,
}, {
    path: '/news',
    component: News,
}
];

const router = new VueRouter({
    routes,
});
export default router;
