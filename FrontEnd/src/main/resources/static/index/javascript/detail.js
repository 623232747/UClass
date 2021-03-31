
var app = new Vue({
    el:'#app',
    data:{
        question:
            {
                title:'关于使用wireshark抓取报文实验',
                user_id:"1",
                user_name:'wzy',
                subject:'计算机网络',
                create_time:'today',
                comment_num:'5',
                answers:[
                    {
                        content:'方法很棒！学习了',
                        create_time:'today',
                        review_num:'1',
                    },
                    {
                        content:'请问老师第二步这里是什么意思？',
                        create_time: 'today',
                        review_num: '1',
                    },
                    {
                        content:'祝老师新年快乐！',
                        create_time: 'today',
                        review_num: '5',
                    },
                ],
                content:'　　WIRESHARK抓取报文实验是怎么回事呢？WIRESHARK相信大家都很熟悉，但是WIRESHARK抓取报文实验是怎么回事呢，下面就让小编带大家一起了解吧。WIRESHARK抓取报文实验，其实就是使用WIRESHARK监听和分析网络流量，大家可能会很惊讶WIRESHARK怎么会抓取报文实验呢？但事实就是这样，小编也感到非常惊讶。这就是关于WIRESHARK抓取报文实验的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！',
            },

        }
    }
)