import changeLogin from './store/index.js';
var app = new Vue({
    el:'#app',
    data:{
        userID:null,
        password:null,
    },
    methods:{
        login(){
            let _this = this;
            if (this.userID===''||this.password===''){
                alert("用户名或密码不可为空！")
            }
            axios.post('http://localhost:8094/login',
                {
                    userID:this.userID,
                    password:this.password,
                },
                {
                    headers:{
                        // @RequestParam需要使用如下这种type进行数据传输
                        'Content-Type':'application/x-www-form-urlencoded',
                    },
                    // 这个其实是在模仿qs库对传输的data进行处理，也可以直接调用qs库
                    // 见 https://blog.csdn.net/u011332271/article/details/100515870
                    // https://blog.csdn.net/qq_43681948/article/details/102815325
                    transformRequest: [
                        function(data) {
                            let ret = "";
                            for (let it in data) {
                                ret +=
                                    encodeURIComponent(it) +
                                    "=" +
                                    encodeURIComponent(data[it]) +
                                    "&";
                            }
                            return ret;
                        }
                    ],
                }).then(function(response){
                console.log(response);
                _this.userToken = response.data.content.token;
                localStorage.setItem('Authorization',_this.userID+"_"+_this.userToken);
                // _this.changeLogin({Authorization:_this.userToken});
                alert("登录成功")
            }).catch(function(error){
                console.log(error);
                alert(error.data);
            });
        },
        register(){
            console.log('Authorization');
            axios.delete('http://localhost:8094/register',
                {
                    headers:{
                        'authorization':localStorage.getItem('Authorization')
                    },

                }
                ).then(function (response){
                    localStorage.setItem('Authorization','')
                console.log(response);
            }).catch(function(error){

                console.log(error);
            });
        }
    }
});