import React, { Component } from 'react';
import Jumbotron from 'react-bootstrap/Jumbotron';
class LocalSearchDetail extends Component {
  render() {

    const { obj } = this.props;

    return (
      <div>
        <Jumbotron>
          <h1>상세 정보</h1>
          {
            Object.keys(obj).length === 0 ?
              <p>
                선택된 내용이 없습니다.
              </p>
              : ""
          }
          <p>
            장소 : {obj.place_name ? obj.place_name : "-"}
          </p>
          <p>
            전화 번호 : {obj.phone ? obj.phone : "-"}
          </p>
          <p>
            지번 주소 : {obj.address_name ? obj.address_name : "-"}
          </p>
          <p>
            도로명 주소 : {obj.road_address_name ? obj.road_address_name : "-"}
          </p>
          <a target={"_blank"} href={"https://map.kakao.com/link/map/" + obj.y + "," + obj.x}>지도 바로 가기</a>
        </Jumbotron>
      </div>
    );
  }

}

export default LocalSearchDetail;