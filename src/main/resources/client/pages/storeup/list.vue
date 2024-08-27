<template>
	<view>
		<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
			<view class="content">
				<view :style='{"minHeight":"100vh","width":"100%","padding":"20rpx 0 0 0","position":"relative","background":"#ffffff","height":"100%"}'>
					<view :style='{"padding":"20rpx 0 0 0","alignItems":"center","flex":"1","display":"flex","width":"calc(98% - 120rpx)","position":"relative","justifyContent":"space-between"}'>
						<view :style='{"backgroundColor":"#f5f5f5","margin":"0 30rpx 0 30rpx","color":"#333333","alignItems":"center","borderRadius":"0px","flex":"1","display":"flex","lineHeight":"64rpx","fontSize":"24rpx","height":"64rpx"}'>
							<text class="iconfont icon-sousuo1" :style='{"margin":"0 16rpx 0 16rpx"}'></text>
							<input v-model="searchForm.name" type="text" placeholder="名称" :style='{"background":"transparent","height":"100%"}'></input>
						</view>
						<button @tap="search" :style='{"border":"0px","padding":"0 40rpx 0 40rpx","margin":"0 20rpx 0 0px","borderRadius":"0px","color":"#333","background":"#fff000","fontSize":"28rpx","lineHeight":"64rpx","height":"64rpx"}'>搜索</button>
					</view>
					<view :style='{"alignItems":"flex-start","flexWrap":"wrap","background":"#ffffff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<view class="uni-product-list" :style='{"padding":"24rpx 24rpx 24rpx 24rpx","margin":"40rpx 0 0 0","alignItems":"flex-start","flexWrap":"wrap","flex":"1","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
							<view @tap="onDetailTap(product)" class="uni-product" :style='{"boxShadow":"0 6rpx 12rpx #eeeeee","margin":"0 0 40rpx 0","backgroundColor":"#ffffff","borderRadius":"8rpx","flexWrap":"wrap","textAlign":"center","display":"flex","width":"48%","position":"relative","justifyContent":"center","height":"auto"}' v-for="(product,index) in list" :key="index">
								<view class="uni-product-title " :style='{"padding":"0px 20rpx 0px 20rpx","margin":"0 0 0px 0","whiteSpace":"nowrap","color":"#333333","textAlign":"left","overflow":"hidden","borderRadius":"8rpx","width":"100%","lineHeight":"52rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"2","height":"52rpx"}'>{{product.name}}</view>
								<image :style='{"border":"0px solid #eeeeee","padding":"0 0 0 0","margin":"0 0 0px 0","objectFit":"cover","borderRadius":"8rpx","display":"inline-block","width":"100%","height":"220rpx"}' mode="aspectFill" class="uni-product-image" v-if="preHttp(product.picture)" :src="product.picture"></image>
								<image :style='{"border":"0px solid #eeeeee","padding":"0 0 0 0","margin":"0 0 0px 0","objectFit":"cover","borderRadius":"8rpx","display":"inline-block","width":"100%","height":"220rpx"}' mode="aspectFill" class="uni-product-image" v-else :src="baseUrl+product.picture"></image>
							</view>
						</view>
					</view>
				</view>
			</view>
		</mescroll-uni>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"名称",
					},
				],
				queryIndex: 0,
				list: [],
				lists: [],
                userid: '',
                type: 1,
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{},
				CustomBar: '0'
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
            if(options.menuJump) {
                this.type=options.menuJump;
            } else {
                this.type = 1;
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods: {
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.name="";
			},
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}
				params['sort'] = 'id';
				params['order'] = 'desc';
		

				if(this.searchForm.name){
					params['name'] = '%' + this.searchForm.name + '%'
				}


				params['type']=this.type;

                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`storeup`, params);
                } else {
                    res = await this.$api.list(`storeup`, params);
                }
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
				this.$utils.jump(`../${item.tablename}/detail?id=${item.refid}`)
			},
			// 修改
			onUpdateTap(id){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('storeup', JSON.stringify([id]));
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.mescroll.resetUpScroll()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}

				searchForm['sort'] = 'id';
				searchForm['order'] = 'desc';
		
				if(this.searchForm.name){
					searchForm['name'] = '%' + this.searchForm.name + '%'
				}
				searchForm['type']=this.type;
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`storeup`, searchForm);
                } else {
                    res = await this.$api.list(`storeup`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
			}
		}
	};
</script>
<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>