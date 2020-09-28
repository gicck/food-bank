import dayjs from "dayjs";

const getDateAndTime = function(date) {
  return dayjs(date)
    .subtract(4, "hour")
    .format("DD/MM/YYYY  HH:mm");
};

export const dateService = {
  getDateAndTime
};
