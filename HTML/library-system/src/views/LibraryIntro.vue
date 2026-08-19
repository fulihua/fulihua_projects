<template>
  <div class="intro-page">
    <!-- 顶部导航 -->
    <div class="nav-wrap">
      <span class="nav-word" @click="$router.push('/')">首页</span>
      <span class="nav-word" @click="$router.push('/intro')">图书馆介绍</span>
      <span class="nav-word" @click="$router.push('/booklist')">全部图书</span>
    </div>

    <!-- 头部横幅标题 -->
    <div class="banner-box">
      <h2>校园图书馆介绍</h2>
      <p>以书为媒，筑造校园精神栖息地</p>
    </div>

    <div class="content-wrap">
      <!-- 板块1：馆舍概况 -->
      <div class="info-card">
        <h3 class="card-title">一、图书馆概况</h3>
        <p>本校图书馆坐落于校园中心区域，建筑面积约6800平方米，共三层开放式阅览空间，是全校师生阅读学习、文献查阅、文化交流的核心场所。图书馆自建成以来，始终秉持“服务育人、书香校园”的建设理念，持续扩充馆藏资源、优化阅览环境、完善借阅服务，为教学科研与学生课外阅读提供全方位支撑。</p>
        <p>馆内划分综合阅览区、文学专区、计算机专业书库、教材教辅区、自习阅览厅、电子阅览室六大功能区域，每日开放时长12小时，全年除法定节假日外正常对外开放。</p>
      </div>

      <!-- 板块2：馆藏资源 -->
      <div class="info-card">
        <h3 class="card-title">二、馆藏图书资源</h3>
        <p>图书馆现有实体藏书两万余册，覆盖多类学科读物：</p>
        <ul class="book-list">
          <li>文学类：中外经典小说、近现代散文、诗歌名著，满足文学阅读需求；</li>
          <li>计算机类：编程开发、网络技术、数据算法、程序设计专业教材；</li>
          <li>教材教辅：高数、大学英语、大学物理等公共课程配套用书；</li>
          <li>拓展读物：历史、哲学、艺术、心理、科普等休闲拓展书籍。</li>
        </ul>
        <p>同时配套电子图书数据库，师生可在线阅览电子书籍、期刊论文、公开课资料，实现线上线下一体化阅读。</p>
      </div>

      <!-- 板块3：开放与借阅规则 -->
      <div class="info-card">
        <h3 class="card-title">三、开放时间与借阅须知</h3>
        <h4>📅 日常开放时间</h4>
        <p>周一至周五：08:00 — 20:00</p>
        <p>周六、周日：09:00 — 18:00</p>

        <h4>📖 借阅规则</h4>
        <ul class="book-list">
          <li>在校学生凭校园卡免费借阅图书，单次最多可借6本；</li>
          <li>借阅期限30天，可线上续借一次，延长15天；</li>
          <li>图书请妥善保管，出现破损、遗失需按规定赔付；</li>
          <li>馆内禁止大声喧哗、饮食，保持安静整洁的阅览环境。</li>
        </ul>
      </div>

      <!-- 板块4：特色活动 -->
      <div class="info-card">
        <h3 class="card-title">四、校园书香特色活动</h3>
        <p>图书馆定期举办各类文化活动，丰富校园课余生活：</p>
        <ul class="book-list">
          <li>每年4月读书月：读书分享会、征文比赛、经典朗诵活动；</li>
          <li>每月好书推荐：线上同步更新热门文学、专业新书；</li>
          <li>主题读书会：名著共读、作家作品赏析交流；</li>
          <li>免费公益讲座：写作技巧、计算机技能、文学鉴赏课堂。</li>
        </ul>
      </div>

      <!-- 板块5：联系信息 -->
      <div class="info-card contact-card">
        <h3 class="card-title">五、咨询联系方式</h3>
        <p>图书馆前台服务台：一楼大厅进门右侧</p>
        <p>服务咨询电话：024-88XXXXXX</p>
        <p>线上咨询：校园图书馆公众号在线客服</p>
        <p>意见箱：图书馆一楼出入口处，欢迎提出改进建议</p>
      </div>
    </div>
  </div>
</template>

<script setup>
// 无需额外逻辑代码
</script>

<style scoped>
/* 页面全局基础 */
.intro-page {
  padding: 0 20px;
  padding-bottom: 60px;
  background-color: #f8f9fa;
  min-height: 100vh;
}

/* 顶部导航栏 与首页样式统一 */
.nav-wrap {
  display: flex;
  justify-content: center;
  gap: 40px;
  margin: 20px 0 30px;
}
.nav-word {
  font-size: 18px;
  font-weight: bold;
  color: #2c3e50;
  cursor: pointer;
  padding: 6px 14px;
  border-radius: 6px;
  transition: all 0.3s ease;
}
.nav-word:hover {
  background-color: #e8edf2;
  color: #3474bb;
}

/* 顶部横幅标题 */
.banner-box {
  text-align: center;
  padding: 40px 20px;
  background: linear-gradient(135deg, #3474bb, #5390d9);
  border-radius: 14px;
  color: #fff;
  margin-bottom: 35px;
}
.banner-box h2 {
  font-size: 30px;
  margin: 0 0 10px;
}
.banner-box p {
  font-size: 16px;
  opacity: 0.9;
  letter-spacing: 1px;
  margin: 0;
}

/* 内容容器居中 */
.content-wrap {
  max-width: 900px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 25px;
}

/* 通用卡片样式，和图书卡片质感统一 */
.info-card {
  background: #ffffff;
  padding: 25px 30px;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
  transition: 0.3s;
}
.info-card:hover {
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.09);
}
/* 底部联系卡片轻微区分 */
.contact-card {
  background: #f4f8fd;
}

/* 卡片标题装饰 */
.card-title {
  font-size: 22px;
  color: #2c3e50;
  padding-bottom: 10px;
  border-bottom: 2px solid #3474bb;
  margin-top: 0;
}
.info-card h4 {
  font-size: 17px;
  color: #3474bb;
  margin: 16px 0 8px;
}

/* 正文文字排版 */
.info-card p {
  font-size: 15px;
  color: #444;
  line-height: 1.8;
  margin: 8px 0;
}
/* 列表样式美化 */
.book-list {
  padding-left: 20px;
}
.book-list li {
  font-size: 15px;
  color: #444;
  line-height: 1.7;
  margin: 6px 0;
}
</style>