import * as echarts from '../../utils/ec-canvas/echarts'
import geoJson from './mapData'

function getMapOption(dbRes) {
  return {
    visualMap: {
      type: 'piecewise',
      pieces: [{ gt: 9 }, { gt: 7, lte: 9 }, { gte: 3, lte: 7 }, { lt: 3 }],
      right: '5%',
      bottom: '5%',
      itemWidth: 8,
      itemHeight: 8,
      textStyle: {
        fontSize: 9
      }
    },
    series: [
      {
        type: 'map',
        left: '8%',
        height: '98%',
        silent: true,
        mapType: 'china',
        label: {
          show: true,
          fontSize: 5
        },
        data: dbRes.map(e => ({
          name: e.name,
          value: e.value
        })),
        animation: false
      }
    ]
  }
}

function getTotalLineOption(dbRes) {
  const totalLineData = ['确诊', '死亡', '治愈'].map(name => ({
    name,
    data: [],
    type: 'line',
    symbol: 'circle',
    smooth: true,
    animation: false
  }))
  for (const element of dbRes) {
    const { _id, confirmedSum, deathSum, curedSum } = element
    totalLineData[0].data.push({
      name: _id,
      value: [_id, confirmedSum]
    })
    totalLineData[1].data.push({
      name: _id,
      value: [_id, deathSum]
    })
    totalLineData[2].data.push({
      name: _id,
      value: [_id, curedSum]
    })
  }
  return {
    grid: {
      containLabel: true,
      top: '18%',
      bottom: '8%',
      left: '6%'
    },
    legend: {
      top: '4%',
      right: '10%',
      data: ['确诊', '死亡', '治愈']
    },
    xAxis: {
      type: 'time',
      axisLine: { show: false },
      axisLabel: {
        formatter: value => new Date(value).toISOString().slice(5, 10)
      },
      splitLine: {
        show: false
      }
    },
    yAxis: {
      type: 'value',
      scale: true,
      axisLine: { show: false }
    },
    series: totalLineData
  }
}

function getNewLineOption(dbRes) {
  const newLineData = ['新增确诊', '新增死亡', '新增治愈'].map(name => ({
    name,
    data: [],
    type: 'line',
    symbol: 'circle',
    smooth: true,
    animation: false
  }))
  for (const element of dbRes) {
    const { _id, confirmedSum, deathSum, curedSum } = element
    newLineData[0].data.push({
      name: _id,
      value: [_id, confirmedSum]
    })
    newLineData[1].data.push({
      name: _id,
      value: [_id, deathSum]
    })
    newLineData[2].data.push({
      name: _id,
      value: [_id, curedSum]
    })
  }
  return {
    grid: {
      containLabel: true,
      top: '18%',
      bottom: '8%',
      left: '6%'
    },
    legend: {
      top: '4%',
      right: '10%',
      data: ['新增确诊', '新增死亡', '新增治愈']
    },
    xAxis: {
      type: 'time',
      axisLine: { show: false },
      axisLabel: {
        formatter: value => new Date(value).toISOString().slice(5, 10)
      },
      splitLine: {
        show: false
      }
    },
    yAxis: {
      type: 'value',
      scale: true,
      axisLine: { show: false }
    },
    series: newLineData
  }
}

function updateMap() {
  const { mapChart } = getApp().globalData
    let that=this
    wx.request({
      url: 'https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5',
      success:function(res){
        var Data = JSON.parse(res.data.data)
        var newArr = []
        // 获取各个省份的数据
        var province = Data.areaTree[0].children;
        for (var i = 0; i < province.length; i++) {
            var json = {
              name: province[i].name,
              value: province[i].today.confirm // 新增确诊
            }
            newArr.push(json)
        }
        mapChart.setOption(getMapOption(newArr))
      },
      fail(err){
        mapChart.setOption(getMapOption([]))
        wx.showToast({
          title: '网络错误',
          icon: 'none',
          duration: 2000
        })
        console.error(err)
      }
    })
}

function updateTotalLine() {
  const { totalLineChart } = getApp().globalData
  let that=this
    wx.request({
      url: 'https://view.inews.qq.com/g2/getOnsInfo?name=disease_other',
      success:function(res){
        var Data = JSON.parse(res.data.data)
        var newArr = []
        // 获取各个日期的数据
        var days = Data.chinaDayList;
        for (var i = 0; i < days.length; i++) {
            let str = "2021-" + days[i].date.replace(/\./, "-") // 2021年
            var json = {
              _id: str,
              confirmedSum: days[i].confirm, // 累计确诊
              deathSum: days[i].dead,  // 累计死亡
              curedSum: days[i].heal // 累计治愈
            }
            newArr.push(json)
        }
        totalLineChart.setOption(getTotalLineOption(newArr))
      },
      fail: function(err) {
            totalLineChart.setOption(getTotalLineOption([]))
            wx.showToast({
              title: '网络错误',
              icon: 'none',
              duration: 2000
            })
            console.error(err)
      }
    })
}

function updateNewLine() {
  const { newLineChart } = getApp().globalData
    let that=this
    wx.request({
      url: 'https://view.inews.qq.com/g2/getOnsInfo?name=disease_other',
      success:function(res){
        var Data = JSON.parse(res.data.data)
        var newArr = []
        // 获取各个日期的数据
        var days = Data.chinaDayAddList;
        for (var i = 0; i < days.length; i++) {
            let str = "2021-" + days[i].date.replace(/\./, "-") // 2021年
            var json = {
              _id: str,
              confirmedSum: days[i].confirm, // 新增确诊
              deathSum: days[i].dead,  // 新增死亡
              curedSum: days[i].heal // 新增治愈
            }
            newArr.push(json)
        }
        newLineChart.setOption(getNewLineOption(newArr))
      },
      fail: function(err) {
            newLineChart.setOption(getNewLineOption([]))
            wx.showToast({
              title: '网络错误',
              icon: 'none',
              duration: 2000
            })
            console.error(err)
      }
    })
}

Page({
  /**
   * 页面的初始数据
   */
  data: {
    list: [],
    confirmedSum: '...',
    deathSum: '...',
    curedSum: '...',
    ecMap: {
      onInit: function(canvas, width, height) {
        const chart = echarts.init(canvas, null, {
          width: width,
          height: height
        })
        canvas.setChart(chart)
        echarts.registerMap('china', geoJson)
        getApp().globalData.mapChart = chart
        updateMap()
        return chart
      }
    },
    ecTotalLine: {
      onInit: function(canvas, width, height) {
        const chart = echarts.init(canvas, null, {
          width: width,
          height: height
        })
        canvas.setChart(chart)
        getApp().globalData.totalLineChart = chart
        updateTotalLine()
        return chart
      }
    },
    ecNewLine: {
      onInit: function(canvas, width, height) {
        const chart = echarts.init(canvas, null, {
          width: width,
          height: height
        })
        canvas.setChart(chart)
        getApp().globalData.newLineChart = chart
        updateNewLine()
        return chart
      }
    }
  },

  firstIn: true,
  updateTotalData: function() {
    let that=this
    wx.request({
      url: 'https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5',
      success:function(res){
        that.setData({
          confirmedSum: JSON.parse(res.data.data).chinaTotal.confirm,
          deathSum: JSON.parse(res.data.data).chinaTotal.dead,
          curedSum: JSON.parse(res.data.data).chinaTotal.heal,
          newConfirm: JSON.parse(res.data.data).chinaAdd.confirm,
          newDeath: JSON.parse(res.data.data).chinaAdd.dead,
          newHeal: JSON.parse(res.data.data).chinaAdd.heal
        })
      },
      fail(res){
        console.log("请求失败",res)
      }
    })
  },
  updateWord: function() {
    this.setData({
      list:[]
    })
    let that = this
    for (let i = 0; i < 7; i++) {
      wx.request({
        url: 'http://10.181.208.48:8080/title' + i,
        success:function(res){
          that.setData({
            list: that.data.list.concat(res.data)
          })
        }
      })
    }
  },
  showDataSrcState: function() {
    wx.showModal({
      title: '数据说明',
      content: '数据来源于阿里健康疫情数据API',
      showCancel: false,
      confirmText: '好的',
      confirmColor: '#1cbbb4'
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    wx.startPullDownRefresh()
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    if (this.firstIn) {
      this.firstIn = false
    } else {
      updateMap()
      updateTotalLine()
      updateNewLine()
    }
    this.updateTotalData()
    this.updateWord()
    wx.stopPullDownRefresh()
  }
})
