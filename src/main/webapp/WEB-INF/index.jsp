<!DOCTYPE html>
<html>
<head>
<title>喷子基地</title>
</head>
<body>
<div id="a1"></div>
<script type="text/javascript" src="/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript">
showPlayer('http://192.168.1.33/hls/ding.m3u8','a1')
function showPlayer(src, id){
     //player
   var flashvars={
        f :'http://localhost:1080/ckplayer/m3u8.swf',
        a :src,
        c :0,
        s:1,
        lv:1//注意，如果是直播，需设置lv:1
    };
    var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always',wmode:'transparent'};
    var video=[src];
    CKobject.embed('http://localhost:1080/ckplayer/ckplayer.swf',id,'ck-video','600','400',false, flashvars ,video, params);

}
//     var flashvars={
//         f:'http://movie.ks.js.cn/flv/other/1_0.flv',
//         c:0
//     };
//     var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always',wmode:'transparent'};
//     CKobject.embedSWF('/ckplayer/ckplayer.swf','a1','ckplayer_a1','600','400',flashvars,params);
</script>
</body>
</html>