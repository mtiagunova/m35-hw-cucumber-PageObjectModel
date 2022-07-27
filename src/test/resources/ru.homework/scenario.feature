Feature: Add a film to a watch later list
  # Позитивный сценарий: после добавления фильма в список "смотреть позже"
  # можно найти его в списке на странице профиля
  Scenario: Film is in my watch later list
    Given url of service 'https://www.ivi.ru'
    Then click search button
    And type film title 'гарри поттер'
    And choose first
    Then click on bookmark
    And hover on profile button and click watch later list
    Then film 'гарри поттер' is in my list

  # Негативный сценарий: некорректный формат номера телефона
  # не позволяет пройти регистрацию
  Scenario: Incorrect phone number format
    Given url of service 'https://www.ivi.ru'
    Then hover on profile button and click registration button
    Then enter phone number '+710020033445'
    And push button to continue
    Then assert that user got message 'Не удалось совершить звонок'