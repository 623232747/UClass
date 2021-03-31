
var app = new Vue({
    el:'#app',
    data:{
        questions:[
            {
                id:1,
                title:'关于使用wireshark抓取报文实验',
                userid:"1",
                userName:'wzy',
                subject:'计算机网络',
                createTime:'today',
                ansNum:'5',
            },
        ]
    },
    method:{
        created:function (){
            axios.get('http://localhost:8095/list').then(

            )
        }
    }

})