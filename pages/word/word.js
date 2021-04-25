Page({
  data: {
    art: '...',
  },
  onReady () {
    wx.setNavigationBarTitle({
      title: '详情页面'
    })
  },
  onLoad (options) {
    var that = this
    wx.request({
      url: 'http://10.181.208.48:8080/article' + options.id,
      success (res) {
        console.log(res.data)
        that.setData({
          art: res.data
        }) 
      }
    })
  }
})