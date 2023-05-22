
      function showTabContent(tabIndex) {
        // 모든 탭 컨텐츠를 숨깁니다.
        const tabContents = document.getElementsByClassName('tab-content');
        for (let i = 0; i < tabContents.length; i++) {
          tabContents[i].style.display = 'none';
        }

        // 선택한 탭 컨텐츠를 보여줍니다.
        const selectedTabContent = document.getElementById(`tab${tabIndex}Content`);
        selectedTabContent.style.display = 'block';
      }

      // 초기에는 모든 탭 컨텐츠를 숨깁니다.
      const tabContents = document.getElementsByClassName('tab-content');
      for (let i = 0; i < tabContents.length; i++) {
        tabContents[i].style.display = 'none';
      }

      // 초기에는 상품 정보 탭의 내용을 보여줍니다.
      showTabContent(1);
   