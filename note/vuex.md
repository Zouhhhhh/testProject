一、Vuex 是什么

Vuex 是一个专为 Vue.js 应用程序开发的**状态管理模式**。它采用集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化。



每一个 Vuex 应用的核心就是 store（仓库）。“store”基本上就是一个容器，它包含着你的应用中大部分的**状态 (state)**。Vuex 和单纯的全局对象有以下两点不同：

1. Vuex 的状态存储是响应式的。当 Vue 组件从 store 中读取状态的时候，若 store 中的状态发生变化，那么相应的组件也会相应地得到高效更新。
2. 你不能直接改变 store 中的状态。改变 store 中的状态的唯一途径就是显式地**提交 (commit) mutation**。这样使得我们可以方便地跟踪每一个状态的变化，从而让我们能够实现一些工具帮助我们更好地了解我们的应用。





二、创建store

1. 引入vuex

   在一个模块化的打包系统中，您必须显式地通过 `Vue.use()` 来安装 Vuex：	

   ```html
   import Vue from 'vue'
   import Vuex from 'vuex'
   
   Vue.use(Vuex)
   ```



2. 创建store

   ```html
   const store = new Vuex.Store({
     state: {
       count: 0
     },
     mutations: {
       increment (state) {
         state.count++
       }
     }
   })
   ```

3. 获取状态对象

   ```html
   console.log(store.state.count);		//通过 store.state 来获取状态对象
   store.commit('increment');			//通过 store.commit 方法触发状态变更
   ```

4. 为所有子组件注入store

   ```html
   new Vue({
     el: '#app',
     store: store,
     //store		//ES6对象的property简写(用在对象某个 property 的 key 和被传入的变量同名时)
   })
   ```

5. 子组件中使用store

   ```html
   methods: {
   	increment() {
   		console.log(this.&store.state.count);	//在子组件中用this.&store调用
   		this.&store.commit('increment');
   	}
   }
   ```



//TODO:放到后面

再次强调，我们通过提交 mutation 的方式，而非直接改变 `store.state.count`，是因为我们想要更明确地追踪到状态的变化。这个简单的约定能够让你的意图更加明显，这样你在阅读代码的时候能更容易地解读应用内部的状态改变。此外，这样也让我们有机会去实现一些能记录每次状态改变，保存状态快照的调试工具。有了它，我们甚至可以实现如时间穿梭般的调试体验。

由于 store 中的状态是响应式的，在组件中调用 store 中的状态简单到仅需要在计算属性中返回即可。触发变化也仅仅是在组件的 methods 中提交 mutation。



二、核心概念

- State（状态集）
- Getters（类似computed，获取状态属性的其他形式）
- Mutations（类似methods，改变状态属性的方法）
- Actions（）
- Modules



（1）State

Vuex 使用**单一状态树**——是的，用一个对象就包含了全部的应用层级状态。至此它便作为一个“唯一数据源“而存在。这也意味着，每个应用将仅仅包含一个 store 实例。



那么我们如何在 Vue 组件中展示状态呢？由于 Vuex 的状态存储是响应式的，从 store 实例中读取状态最简单的方法就是在计算属性中返回某个状态：

```html
// 创建一个 Counter 组件
const Counter = {
  template: `<div>{{ count }}</div>`,
  computed: {
    count () {
      return store.state.count
    }
  }
}
```

如果是在子组件中，则可以在父组件通过”store“选项，将状态从根组件注入到每一个子组件中：

```html
const Counter = {
  template: `<div>{{ count }}</div>`,
  computed: {
    count () {
      return this.$store.state.count
    }
  }
}
```



通过mapState辅助函数帮助生成computed

```html
// 在单独构建的版本中辅助函数为 Vuex.mapState
import { mapState } from 'vuex'

export default {
  // ...
  computed: mapState({
    // 箭头函数可使代码更简练
    count: state => state.count,

    // 传字符串参数 'count' 等同于 `state => state.count`
    countAlias: 'count',

    // 为了能够使用 `this` 获取局部状态，必须使用常规函数
    countPlusLocalState (state) {
      return state.count + this.localCount
    }
  })
}
```



`mapState` 函数返回的是一个对象。如果要将它与局部计算属性混合使用，就需要将局部计算属性和mapState函数返回的对象合并成一个对象，这里用**对象展开符**

```html
//对象展开符合并数组
let a = [1, 2];
let b = [3, 4, 5];
let c = [...a, ...b];	//c = [1,2,3,4,5]
```

```html
//解构赋值
let c = [1,2,3,4,5];
let [a, ...b] = c;	//a = [1], b = [2,3,4,5]
```

```html
//解构参数
//解构前
function setCookie(name, value, options) {
    options = options || {};
    let secure = options.secure,
        path = options.path,
        domain = options.domain,
        expires = options.expires;
    //其他代码
}
setCookie('type', 'js', {secure: true, path: '/example', domain: 'test', expires: 60});


//解构后
function setCookie(name, value, {secure, path, domain, expires}) {
    console.log(expires); // 60
    //其他代码
}
setCookie('type', 'js', 
    {secure: true, path: '/example', domain: 'test', expires: 60});

//解构参数与一般的参数不同点在于，它是一个必须要传值的参数，如果不传，则会引发程序报错
```



则

```html
computed: {
  localComputed () { /* ... */ },
  // 使用对象展开运算符将此对象混入到外部对象中
  ...mapState({
    // ...
  })
}
```





（2）Getters

有时候我们需要从 store 中的 state 中派生出一些状态，Vuex 允许我们在 store 中定义“getter”（可以认为是 store 的计算属性）。就像计算属性一样，getter 的返回值会根据它的依赖被缓存起来，且只有当它的依赖值发生了改变才会被重新计算。



Getter 接受 state 作为其第一个参数：

```html
const store = new Vuex.Store({
  state: {
    todos: [
      { id: 1, text: '...', done: true },
      { id: 2, text: '...', done: false }
    ]
  },
  getters: {
	doneTodos: state => {
		return state.todos.filter(todo => todo.done);
	}
  }
```



以属性的形式访问

Getter 会暴露为 `store.getters` 对象，你可以以属性的形式访问这些值：

```html
store.getters.doneTodos // -> [{ id: 1, text: '...', done: true }]
```

还可以传入getters为第二个参数

```html
getters: {
  // ...
  doneTodosCount: (state, getters) => {
    return getters.doneTodos.length
  }
}
```





以方法的形式访问

```html
getters: {
  // ...
  getTodoById: (state) => (id) => {
    return state.todos.find(todo => todo.id === id)
  }
}

store.getters.getTodoById(2) // -> { id: 2, text: '...', done: false }
```





mapGetters辅助函数

其实与mapStates辅助函数差不多，将store中的getters也是映射到局部计算属性

```html
import { mapGetters } from 'vuex'

export default {
  // ...
  computed: {
  // 使用对象展开运算符将 getter 混入 computed 对象中
    ...mapGetters([
      'doneTodosCount',
      'anotherGetter',
      // ...
    ])
  }
}
```







（3）Mutations

- 更改 Vuex 的 store 中的状态的唯一方法是提交 mutation。

- 每个 mutation 都有一个字符串的 **事件类型 (type)** 和 一个 **回调函数 (handler)**，接受state为第一个参数。

- 当触发一个类型为 `increment` 的 mutation 时，调用此函数。

- 要唤醒一个 mutation handler，你需要以相应的 type 调用 **store.commit** 方法：

```html
store.commit('increment')
```

```html
store.commit('increment', n)  //提交载荷（额外参数）
```



Mutation必须是同步函数





mapMutations辅助函数

将组件中的 methods 映射为 `store.commit` 调用

```html
//使用mapMutations前

export default {
  // ...
  methods: {

	increment() {
		this.&store.commit('increment');
	},
	incrementBy(amount) {
		this.&store.commit('incrementBy', amount);
	},
	add() {
		this.&store.commit('increment');
	}

  }
}
```

```html
import { mapMutations } from 'vuex'

export default {
  // ...
  methods: {
    ...mapMutations([
      'increment', // 将 `this.increment()` 映射为 `this.$store.commit('increment')`

      // `mapMutations` 也支持载荷：
      'incrementBy' // 将 `this.incrementBy(amount)` 映射为 `this.$store.commit('incrementBy', amount)`
    ]),
    ...mapMutations({
      add: 'increment' // 将 `this.add()` 映射为 `this.$store.commit('increment')`
    })
  }
}
```







（4）Action

Action 类似于 mutation，不同在于：

- Action 提交的是 mutation，而不是直接变更状态。
- Action 可以包含任意异步操作。





